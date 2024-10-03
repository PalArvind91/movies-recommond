package com.example.movie_recommender.repository;

import com.example.movie_recommender.model.Actor;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor , Long> {
}
