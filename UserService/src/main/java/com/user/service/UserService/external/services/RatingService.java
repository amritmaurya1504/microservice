package com.user.service.UserService.external.services;

import com.user.service.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

//    @PostMapping("/ratings")
//    Rating createRating(Rating values);
//
//    @DeleteMapping("/ratings/{ratingId}")
//    void deleteRating(@PathVariable String ratingId);

}
