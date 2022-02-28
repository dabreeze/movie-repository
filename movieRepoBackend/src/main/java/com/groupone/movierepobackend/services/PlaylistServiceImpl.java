package com.groupone.movierepobackend.services;

import com.groupone.movierepobackend.data.dtos.MovieRequestDto;
import com.groupone.movierepobackend.data.dtos.PlaylistRequestDto;
import com.groupone.movierepobackend.data.models.Movie;
import com.groupone.movierepobackend.data.models.Playlist;
import com.groupone.movierepobackend.data.models.UserAccount;
import com.groupone.movierepobackend.data.repositories.MovieRepository;
import com.groupone.movierepobackend.data.repositories.PlaylistRepo;
import com.groupone.movierepobackend.data.repositories.UserAccountRepository;
import com.groupone.movierepobackend.web.exceptions.MovieRepositoryException;
import com.groupone.movierepobackend.web.exceptions.PlaylistDoesNotExistException;
import com.groupone.movierepobackend.web.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PlaylistServiceImpl implements PlaylistService{

    @Autowired
    PlaylistRepo playlistRepo;

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    MovieRepository movieRepository;


    @Override
    public Playlist CreatePlaylist(PlaylistRequestDto playlistRequestDto) throws PlaylistDoesNotExistException, UserNotFoundException {

        Optional <UserAccount>queryUser = userAccountRepository.findById(playlistRequestDto.getId());

        if (queryUser.isEmpty()){
            throw new UserNotFoundException("User with Id "+ playlistRequestDto.getUserId()+ "Does not exist");
        }

        UserAccount existingUser = queryUser.get();

        Playlist playlist = new Playlist();
        playlist.setId(playlistRequestDto.getId());
        playlist.setName(playlistRequestDto.getName());
        playlist.setDescription(playlistRequestDto.getDescription());


        return playlistRepo.save(playlist);
    }

    @Override
    public Playlist addMovieToPlaylist(MovieRequestDto movieRequestDto) throws MovieRepositoryException {
        // find user
//        Optional<UserAccount>userAccount = userAccountRepository.findById(u)
        //find the movie
        Optional<Playlist> playlist = playlistRepo.findById(movieRequestDto.getPlaylistId());
        if (playlist == null){
            throw new PlaylistDoesNotExistException("playlist with the id "+ movieRequestDto.getPlaylistId() +"does not exist");
        }
        Playlist existingPlaylist = playlist.get();

        Movie playlistMovie = Movie.builder()
                .movieName(movieRequestDto.getMovieName())
                .description("comedy").rating(movieRequestDto.getRating()).build();
        existingPlaylist.addMovie(playlistMovie);
        //check that movie is not null
        //add movie to playlist
        //save playlist
        return existingPlaylist;
    }

    @Override
    public Playlist viewPlaylistById(Long userId) throws UserNotFoundException, PlaylistDoesNotExistException {

        Optional <Playlist>playlist = playlistRepo.findById(userId);
        if (playlist == null){
            throw new PlaylistDoesNotExistException("playlist does not exist");
        }
        Playlist aPlaylist = playlist.get();

        return aPlaylist;
    }

    @Override
    public List<Playlist> viewAllPlaylist(Playlist playlist) throws UserNotFoundException {
        return playlistRepo.findAll();
    }


//    private PlaylistResponseDto buildPlaylistResponse(Movie movie) throws UserNotFoundException {
//        return PlaylistResponseDto.builder().movieItems(m.getListOfMovies())
//    }


}
