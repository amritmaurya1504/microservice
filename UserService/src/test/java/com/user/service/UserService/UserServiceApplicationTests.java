package com.user.service.UserService;

import com.user.service.UserService.entities.Rating;
import com.user.service.UserService.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

//	@Test
//	void createRating(){
//		Rating rating = Rating.builder().rating(5).userId("f45a9b57-4fbc-4467-a041-4f35003db1bf").feedback("This is " +
//				"created using feign client").hotelId("4d9dd334-67fd-4663-8f64-27ac45edfed7").build();
//		Rating savedRating = ratingService.createRating(rating);
//
//		System.out.println("new rating created!");
//	}

}
