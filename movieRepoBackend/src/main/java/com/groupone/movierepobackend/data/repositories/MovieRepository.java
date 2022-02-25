package com.groupone.movierepobackend.data.repositories;

import com.groupone.movierepobackend.data.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository <Movie, Long>{
//    Optional<Movie> findMovieByTitle(String title);
}
