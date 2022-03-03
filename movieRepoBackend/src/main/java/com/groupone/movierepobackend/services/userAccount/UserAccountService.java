package com.groupone.movierepobackend.services.userAccount;

import com.groupone.movierepobackend.data.dtos.UserAccountRequestDto;
import com.groupone.movierepobackend.data.dtos.UserAccountResponseDto;
import com.groupone.movierepobackend.data.models.UserAccount;
import com.groupone.movierepobackend.web.exceptions.UserAccountException;

import java.util.List;


public interface UserAccountService {

    UserAccountResponseDto createMovieUser (UserAccountRequestDto requestDto) throws UserAccountException;
    List<UserAccount> getAllUsers();
    UserAccount findUserById(Long userId) throws UserAccountException;

}
