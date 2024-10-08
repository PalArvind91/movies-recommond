package com.example.movie_recommender.service;

import com.example.movie_recommender.model.*;
import com.example.movie_recommender.repository.MoviesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

   @Autowired
   private  MoviesRepository moviesRepository;

    public List<Movies> getRecommendedMovies(User user){
        List<Interaction> interactionList = user.getInteractions();
        Set<Genre> userGener = new HashSet<>();
        for (Interaction interaction : interactionList) {
            Movies movie = interaction.getMovies();
            List<Genre> genres = movie.getGenres();
            userGener.addAll(genres);
        }
        List<Movies> moviesLisst = new ArrayList<>();
        for (Genre genre : userGener){
                List<Movies> moviesWithGenre = moviesRepository.findByGenres(Collections.singletonList(genre));
                moviesLisst.addAll(moviesWithGenre);
        }


        return  moviesLisst.stream().distinct().collect(Collectors.toList());
    }


}
