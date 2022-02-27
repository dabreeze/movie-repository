package com.groupone.movierepobackend.data.repositories;

import com.groupone.movierepobackend.data.models.Movie;
import com.groupone.movierepobackend.data.models.MovieGenre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;

import static com.groupone.movierepobackend.data.models.MovieGenre.*;
import static org.assertj.core.api.Assertions.assertThat;

//@DataJpaTest
@SpringBootTest
@Sql(scripts = "/db/insert.sql")
class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    Movie movie;

    @BeforeEach
    void setUp() {
        List<MovieGenre> genres = Arrays.asList(ACTION, SCI_FI, HORROR);

        movie = Movie.builder()
                .title("Half of a yellow sun")
                .description("Blood and gore in the motherland")
                .imDbRating(9.8)
                .genres(genres)
                .build();
    }

    @Test
    void savedMovieCanBeRetrievedFromTheDatabaseTest() {
        Movie foundMovie = movieRepository.findById(2L).orElse(null);
        assertThat(foundMovie).isNotNull();
        assertThat(foundMovie.getTitle()).isEqualTo("RushUkraine 2022");
    }

    @Test
    void movieDetailsCanBeCreatedTest() {
        assertThat(movieRepository.findAll()).isNotNull();
        assertThat(movieRepository.findAll().size()).isEqualTo(3);
    }
}