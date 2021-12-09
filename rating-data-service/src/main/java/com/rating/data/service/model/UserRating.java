package com.rating.data.service.model;

import java.util.Arrays;
import java.util.List;

public class UserRating {
	private List<Rating> ratings;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Rating> getRating() {
		return ratings;
	}

	public void setRating(List<Rating> userRating) {
		this.ratings = userRating;
	}

	public void initData(String userId) {
		this.setUserId(userId);
		this.setRating(Arrays.asList(new Rating("105", 3), new Rating("200", 2)));
	}
}
