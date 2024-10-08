package com.example.movie_recommender.repository;

import com.example.movie_recommender.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role ,Integer> {
}
