package com.movie.catalog.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.catalog.models.Rating;
import com.movie.catalog.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingInfo {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRating getUserRating(String userId) {
		return restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userId, UserRating.class);
	}

	public UserRating getFallbackUserRating(String userId) {

		UserRating userRating = new UserRating();
		userRating.setUserId(userId);
		userRating.setRating(Arrays.asList(new Rating("0", 0)));
		return userRating;
	}
}
