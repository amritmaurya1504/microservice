package com.rating.RatingService.RatingService.services;

import com.rating.RatingService.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {
    //create
    Rating create(Rating rating);


    //get all ratings
    List<Rating> getRatings();

    //get all by UserId
    List<Rating> getRatingByUserId(String userId);

    //get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);
}
