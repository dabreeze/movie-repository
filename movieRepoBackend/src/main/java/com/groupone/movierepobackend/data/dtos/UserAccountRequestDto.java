package com.groupone.movierepobackend.data.dtos;


import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountRequestDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
