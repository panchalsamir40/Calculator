package com.movie.catalog.models;

public class Rating {
	private String movieId;
	private int rating;

	public Rating() {
	}

	public Rating(String movieId, int i) {
		this.movieId = movieId;
		this.rating = i;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
