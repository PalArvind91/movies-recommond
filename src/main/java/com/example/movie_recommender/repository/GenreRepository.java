package com.example.movie_recommender.repository;

import com.example.movie_recommender.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre , Long> {
}
