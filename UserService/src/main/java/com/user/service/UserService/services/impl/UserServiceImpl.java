package com.user.service.UserService.services.impl;

import com.user.service.UserService.entities.Hotel;
import com.user.service.UserService.entities.Rating;
import com.user.service.UserService.entities.User;
import com.user.service.UserService.exceptions.ResourceNotFoundException;
import com.user.service.UserService.repositories.UserRepo;
import com.user.service.UserService.services.UserServices;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        // getting user data from user repository
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("User with given id is not found on server! : " + userId));

        // fetch rating of the above user from rating service
        // url: http://localhost:8083/ratings/user/c806f39c-65da-41a0-974d-b829adb9023f
        Rating[] ratingsOfUser = restTemplate.getForObject(
                "http://localhost:8083/ratings/user/"+userId,
                Rating[].class);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        // fetch hotel details
        List<Rating> ratingList = ratings.stream().map(rating -> {
            // api call to hotel service to get the hotel
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity(
                    "http://localhost:8082/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel body = forEntity.getBody();
            rating.setHotel(body);
            // set the hotel to rating
             return rating;
        }).toList();

        user.setRatings(ratingList);

        return user;

    }
}
