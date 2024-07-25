package com.user.service.UserService.controllers;

import com.user.service.UserService.entities.User;
import com.user.service.UserService.services.UserServices;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
       User newUser = userServices.saveUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

        @GetMapping("/{userId}")
    //    @CircuitBreaker(name = "ratingHotel", fallbackMethod = "ratingHotelFallback")
        @RateLimiter(name = "userRateLimiter", fallbackMethod = "userRateLimiterFallback")
        public ResponseEntity<User> getSingleUser(@PathVariable String userId){
            User user = userServices.getUser(userId);
            return ResponseEntity.ok(user);
        }

        // creating fall back method for circuitbreaker
        public ResponseEntity<User> userRateLimiterFallback(String userId, Exception ex){
            System.out.println("Fallback is executed because service is down : " + ex.getMessage());
            User user = User.builder().userId("1234").userName("Dummy").userEmail("dummy@gmail.com").userPhone(12345).userBio("This user is " +
                    "created due to some service is down").build();
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userServices.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
