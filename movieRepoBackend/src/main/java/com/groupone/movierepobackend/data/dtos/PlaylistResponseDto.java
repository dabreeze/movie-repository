package com.groupone.movierepobackend.data.dtos;

import com.groupone.movierepobackend.data.models.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PlaylistResponseDto {
    private List<Movie> movieItems;
}
