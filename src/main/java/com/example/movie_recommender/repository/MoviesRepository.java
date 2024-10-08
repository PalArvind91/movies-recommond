package com.example.movie_recommender.repository;

import com.example.movie_recommender.model.Genre;
import com.example.movie_recommender.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {
    List<Movies> findByGenres(List<Genre> geners);


}
