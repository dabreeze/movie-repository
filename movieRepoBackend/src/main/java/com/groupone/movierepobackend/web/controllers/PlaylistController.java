package com.groupone.movierepobackend.web.controllers;

import com.groupone.movierepobackend.data.dtos.PlaylistRequestDto;
import com.groupone.movierepobackend.data.dtos.PlaylistResponseDto;
import com.groupone.movierepobackend.data.models.Playlist;
import com.groupone.movierepobackend.services.PlaylistService;
import com.groupone.movierepobackend.web.exceptions.PlaylistDoesNotExistException;
import com.groupone.movierepobackend.web.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    @Autowired
    PlaylistService playlistServiceImpl;

    @Autowired
    PlaylistService playlistService;

    @PostMapping()
    public ResponseEntity<?> createPlaylist(@RequestBody PlaylistRequestDto playlistRequestDto){
        PlaylistResponseDto playlistResponseDto = null;

        try {
            playlistResponseDto = playlistServiceImpl.CreatePlaylist(playlistRequestDto);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (PlaylistDoesNotExistException e) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok().body(playlistResponseDto);
    }

    @GetMapping("/{}userId")
    public ResponseEntity<?> viewPlaylist(@PathVariable("userId") Long id){
        try{
            PlaylistResponseDto responseDto = playlistServiceImpl.viewPlaylistById(id);
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        } catch (PlaylistDoesNotExistException | UserNotFoundException e) {
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    }

    @GetMapping
    public ResponseEntity<?> viewAllPlaylist() throws UserNotFoundException {
        log.info("here----->");
        List<Playlist> playlistList = playlistService.viewAllPlaylist();
        return ResponseEntity.ok().body(playlistList);
    }

}
