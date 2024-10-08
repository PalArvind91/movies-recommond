package com.example.movie_recommender.service;

import com.example.movie_recommender.model.User;
import com.example.movie_recommender.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

}
