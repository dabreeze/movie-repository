package com.groupone.movierepobackend.data.models;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private UserAccount user;
    private String name;
    private String description;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "list_of_movies_id")
    private List<Movie> listOfMovies;

    @CreationTimestamp
    private LocalDateTime timeCreated;

    public void addMovie(Movie myMovie) {
        if(listOfMovies == null){
            listOfMovies = new ArrayList<>();
        }
        listOfMovies.add(myMovie);
    }


}
