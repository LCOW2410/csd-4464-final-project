package com.example.moviecatalogue.service;

import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.model.TmdbResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class MovieService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    // Get popular movies
    public List<Movie> getPopularMovies() {
        String uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/movie/popular")
                .queryParam("api_key", apiKey)
                .toUriString();
        TmdbResponse response = restTemplate.getForObject(uri, TmdbResponse.class);
        return response != null ? response.getResults() : null;
    }

    // Search movies by title
    public List<Movie> searchMovies(String query) {
        String uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/search/movie")
                .queryParam("api_key", apiKey)
                .queryParam("query", query)
                .toUriString();
        TmdbResponse response = restTemplate.getForObject(uri, TmdbResponse.class);
        return response != null ? response.getResults() : null;
    }

    // Get movie details by ID
    public Movie getMovieDetails(int movieId) {
        String uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/movie/" + movieId)
                .queryParam("api_key", apiKey)
                .toUriString();
        System.out.println("Movie details URI: " + uri);
        return restTemplate.getForObject(uri, Movie.class);
    }

}
