package com.groupone.movierepobackend.services;

import com.groupone.movierepobackend.data.dtos.MovieRequestDto;
import com.groupone.movierepobackend.data.dtos.PlaylistRequestDto;
import com.groupone.movierepobackend.data.dtos.PlaylistResponseDto;
import com.groupone.movierepobackend.data.models.Playlist;
import com.groupone.movierepobackend.web.exceptions.MovieRepositoryException;
import com.groupone.movierepobackend.web.exceptions.PlaylistDoesNotExistException;
import com.groupone.movierepobackend.web.exceptions.UserNotFoundException;

import java.util.List;


public interface PlaylistService {
    Playlist CreatePlaylist(PlaylistRequestDto playlist) throws PlaylistDoesNotExistException, UserNotFoundException;
    Playlist addMovieToPlaylist(MovieRequestDto movieRequestDto)
        throws MovieRepositoryException;
    Playlist viewPlaylistById(Long userId) throws UserNotFoundException, PlaylistDoesNotExistException;

    List<Playlist> viewAllPlaylist(Playlist playlist) throws UserNotFoundException;

//    PlaylistResponseDto updatePlaylist(PlaylistUpdateDto playlistUpdateDto) throws UserNotFoundException, MovieRepositoryException;
}
