package com.groupone.movierepobackend.web.controllers;


import com.groupone.movierepobackend.data.dtos.UserAccountRequestDto;
import com.groupone.movierepobackend.data.dtos.UserAccountResponseDto;
import com.groupone.movierepobackend.services.userAccount.UserAccountService;
import com.groupone.movierepobackend.web.exceptions.UserAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class UserAccountController {

    @Autowired
    UserAccountService userAccountService;

    @PostMapping
    public ResponseEntity<?> createUserAccount(@RequestBody UserAccountRequestDto userAccountRequestDto){
        try {
            UserAccountResponseDto responseDto = userAccountService.createMovieUser(userAccountRequestDto);
            return ResponseEntity.ok().body(responseDto);
        } catch (UserAccountException ex){
            return ResponseEntity.badRequest().body(ex);
        }

    }
}
