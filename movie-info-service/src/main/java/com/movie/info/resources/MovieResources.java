package com.movie.info.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movie.info.model.Movie;
import com.movie.info.model.MovieSummery;

@RestController
@RequestMapping("/movies")
public class MovieResources {

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {

		MovieSummery movieSummery = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummery.class);

		return new Movie(movieId, movieSummery.getTitle(), movieSummery.getOverview());
	}
}
