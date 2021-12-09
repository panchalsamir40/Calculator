package com.movie.catalog.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movie.catalog.models.CatalogItem;
import com.movie.catalog.models.UserRating;
import com.movie.catalog.services.MovieInfo;
import com.movie.catalog.services.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	MovieInfo movieInfo;

	@Autowired
	UserRatingInfo userRatingInfo;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalogItems(@PathVariable String userId) {

		UserRating userRating = userRatingInfo.getUserRating(userId);

		return userRating.getRating().stream().map(rating -> {

			return movieInfo.getCatalogItem(rating);
		}).collect(Collectors.toList());
	}

	public List<CatalogItem> getFallbackCatalog(@PathVariable String userId) {
		return Arrays.asList(new CatalogItem("No movie", "", 0));
	}

}
