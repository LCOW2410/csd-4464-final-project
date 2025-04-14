package com.example.moviecatalogue.controller;

import com.example.moviecatalogue.model.FavoriteMovie;
import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.service.FavoriteService;
import com.example.moviecatalogue.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;
    private final FavoriteService favoriteService;

    public MovieController(MovieService movieService, FavoriteService favoriteService) {
        this.movieService = movieService;
        this.favoriteService = favoriteService;
    }

    // Main page: list popular movies
    @GetMapping("/")
    public String showPopularMovies(Model model) {
        List<Movie> movies = movieService.getPopularMovies();
        // Log the list to verify it isn’t null or contains null items
        System.out.println("Movies: " + movies);
        model.addAttribute("movies", movies);
        return "movies";
    }


    // Search movies
    @GetMapping("/search")
    public String searchMovies(@RequestParam("query") String query, Model model) {
        List<Movie> movies = movieService.searchMovies(query);
        model.addAttribute("movies", movies);
        return "movies";
    }

    // Movie detail page
    @GetMapping("/movie/{id}")
    public String movieDetails(@PathVariable("id") int id, Model model) {
        Movie movie = movieService.getMovieDetails(id);
        System.out.println("Retrieved movie: " + movie);
        model.addAttribute("movie", movie);
        return "detail";
    }


    // View favorite movies
    @GetMapping("/favorites")
    public String showFavorites(Model model) {
        List<FavoriteMovie> favorites = favoriteService.getAllFavorites();
        if (favorites == null) {
            favorites = new ArrayList<>();
        }
        model.addAttribute("favorites", favorites);
        return "favorites";
    }



    // Add a movie to favorites (from list or detail page)
    @PostMapping("/favorites/add")
    public String addFavorite(@RequestParam int id,
                              @RequestParam String title,
                              @RequestParam String posterPath) {
        FavoriteMovie favorite = new FavoriteMovie(id, title, posterPath);
        favoriteService.addFavorite(favorite);
        return "redirect:/favorites";
    }

    // Remove a movie from favorites
    @PostMapping("/favorites/remove")
    public String removeFavorite(@RequestParam int id) {
        favoriteService.removeFavorite(id);
        return "redirect:/favorites";
    }
}
