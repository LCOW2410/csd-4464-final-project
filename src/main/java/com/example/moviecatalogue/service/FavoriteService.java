package com.example.moviecatalogue.service;

import com.example.moviecatalogue.model.FavoriteMovie;
import com.example.moviecatalogue.repository.FavoriteMovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteMovieRepository repository;

    public FavoriteService(FavoriteMovieRepository repository) {
        this.repository = repository;
    }

    public List<FavoriteMovie> getAllFavorites() {
        return repository.findAll();
    }

    public void addFavorite(FavoriteMovie movie) {
        repository.save(movie);
    }

    public void removeFavorite(int movieId) {
        repository.deleteById(movieId);
    }
}
