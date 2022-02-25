package com.groupone.movierepobackend.services;

import com.groupone.movierepobackend.data.dtos.MovieRequestDto;
import com.groupone.movierepobackend.data.dtos.PlaylistRequestDto;
import com.groupone.movierepobackend.data.dtos.PlaylistResponseDto;
import com.groupone.movierepobackend.data.models.Movie;
import com.groupone.movierepobackend.data.models.Playlist;
import com.groupone.movierepobackend.data.repositories.MovieRepository;
import com.groupone.movierepobackend.data.repositories.PlaylistRepo;
import com.groupone.movierepobackend.web.exceptions.MovieRepositoryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlaylistServiceImplTest {

    @Autowired
    PlaylistService playlistService;

    @Autowired
    PlaylistRepo playlistRepo;

    @Autowired
    MovieRepository movieRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createPlaylist() {

        Playlist playlist = new Playlist();

        playlist.setName("Hollywood Movies");
        playlist.setDescription("American movies of the old");
        playlist.setId(1L);
        Playlist savedPlaylist = playlistRepo.save(playlist);
        assertThat(savedPlaylist).isNotNull();
        assertThat(savedPlaylist.getName()).isEqualTo("Hollywood Movies");
    }

    @Test
    void addMovieToPlaylist() throws MovieRepositoryException {
        MovieRequestDto movieRequestDto = new MovieRequestDto();
        movieRequestDto.setPlaylistId(1L);
        movieRequestDto.setId(1L);
        movieRequestDto.setDescription("Latest american movie");
        movieRequestDto.setMovieName("Mr bean");
        movieRequestDto.setRating(5.0);

        assertThat(movieRequestDto.getPlaylistId()).isEqualTo(1L);
        assertThat(movieRequestDto.getMovieName()).isEqualTo("Mr bean");

        Playlist playlist = playlistService.addMovieToPlaylist(movieRequestDto);
//        Playlist savePlaylist = playlistRepo.save(playlist);

        assertThat(playlist.getListOfMovies().size()).isEqualTo(1);


    }

    @Test
    void viewPlaylistById() {
        Playlist playlist = playlistRepo.findById(1L).orElse(null);
//
        assertThat(playlist.getId()).isEqualTo(1L);

    }

    @Test
    void viewAllPlaylistTest(){
        List<Playlist> playlist = playlistRepo.findAll();
        assertThat(playlist.size()).isEqualTo(1);
    }
}