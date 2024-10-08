package com.example.movie_recommender.controller;

import com.example.movie_recommender.model.Movies;
import com.example.movie_recommender.model.User;
import com.example.movie_recommender.repository.UserRepository;
import com.example.movie_recommender.service.MovieService;
import com.example.movie_recommender.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
@RequiredArgsConstructor
public class MoviesRecommendationController {
    @Autowired
    private  MovieService movieService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Movies>> getRecommendations(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        if(user == null)
            return ResponseEntity.notFound().build();
        List<Movies> recommendedMovies = movieService.getRecommendedMovies(user);

        return ResponseEntity.ok(recommendedMovies);
    }

    /*@PostMapping("/")
    public ResponseEntity<Movies> createMovies(@RequestBody Movies movies){
        Movies movies1 = movieService.createMovies(movies);
        return ResponseEntity.ok(movies1);
    }*/
}
