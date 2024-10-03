package com.example.movie_recommender.repository;

import com.example.movie_recommender.model.Movies;
import com.example.movie_recommender.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepositoory extends JpaRepository<Rating , Long> {
    List<Rating> findByMovie(Movies movie);
}
