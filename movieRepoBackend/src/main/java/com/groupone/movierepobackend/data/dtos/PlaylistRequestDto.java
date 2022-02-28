package com.groupone.movierepobackend.data.dtos;

import com.groupone.movierepobackend.data.models.MovieGenre;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PlaylistRequestDto {
    private Long id;
    private Long userId;
//    private  Long ;
    private String name;
    private String Description;
    private LocalDateTime timeCreated;
//    private MovieGenre movieGenre;

}
