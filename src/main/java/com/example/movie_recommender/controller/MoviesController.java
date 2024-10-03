package com.example.movie_recommender.controller;

import com.example.movie_recommender.model.Movies;
import com.example.movie_recommender.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MoviesController {
    private final MovieService movieService;

    @GetMapping("/{id}/recommendations")
    public ResponseEntity<List<Movies>> getRecommendations(@PathVariable Long id) {
        List<Movies> recommendedMovies = movieService.getRecommendedMovies(id);
        return ResponseEntity.ok(recommendedMovies);
    }
}
