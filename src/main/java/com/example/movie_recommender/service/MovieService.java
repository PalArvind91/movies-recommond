package com.example.movie_recommender.service;

import com.example.movie_recommender.model.Movies;
import com.example.movie_recommender.model.Rating;
import com.example.movie_recommender.repository.MoviesRepository;
import com.example.movie_recommender.repository.RatingRepositoory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MoviesRepository moviesRepository;
    private final RatingRepositoory ratingRepositoory;

    public List<Movies> getRecommendedMovies(Long moviesId){
        List<Movies> moviesLisst;
        Movies movies = moviesRepository.findById(moviesId)
                .orElseThrow(()->new RuntimeException("movies not found"));
        moviesLisst=  ratingRepositoory.findByMovie(movies)
                 .stream()
                 .sorted(Comparator.comparing(Rating::getFinalScore).reversed())
                 .map(rating->rating.getMovies())
                 .distinct().limit(5)
                 .collect(Collectors.toList());
         return moviesLisst;
    }
}
