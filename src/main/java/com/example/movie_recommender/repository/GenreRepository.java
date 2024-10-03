package com.example.movie_recommender.repository;

import com.example.movie_recommender.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre , Long> {
}
