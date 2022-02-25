package com.groupone.movierepobackend.services.userAccount;

import com.groupone.movierepobackend.data.dtos.UserAccountRequestDto;
import com.groupone.movierepobackend.data.dtos.UserAccountResponseDto;
import com.groupone.movierepobackend.web.exceptions.UserAccountException;


public interface UserAccountService {

    UserAccountResponseDto createMovieUser (UserAccountRequestDto requestDto) throws UserAccountException;

}
