package com.groupone.movierepobackend.data.dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserAccountResponseDto {

    private String firstName;
    private String lastName;
    private String email;

}
