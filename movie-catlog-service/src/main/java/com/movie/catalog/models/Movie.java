package com.movie.catalog.models;

public class Movie {

	public Movie() {
	}

	private String movieId;
	private String name;
	private String description;

	public Movie(String movieId, String name) {
		this.movieId = movieId;
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
