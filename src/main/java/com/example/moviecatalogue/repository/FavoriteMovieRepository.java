package com.example.moviecatalogue.repository;

import com.example.moviecatalogue.model.FavoriteMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovie, Integer> {
}
