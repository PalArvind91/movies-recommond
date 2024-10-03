package com.example.movie_recommender.repository;

import com.example.movie_recommender.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
