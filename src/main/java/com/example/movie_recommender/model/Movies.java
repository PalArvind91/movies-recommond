package com.example.movie_recommender.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movies_id;
    private String movies_title;
    private String movies_description;
    private String director;
    @ManyToMany
    @JoinTable(name = "movices_actor", joinColumns = @JoinColumn(name = "movies_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actor;

    @ManyToMany
    private List<Genre> genres;
}
