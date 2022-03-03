package com.groupone.movierepobackend.web.controllers;


import com.groupone.movierepobackend.data.dtos.UserAccountRequestDto;
import com.groupone.movierepobackend.data.dtos.UserAccountResponseDto;
import com.groupone.movierepobackend.data.models.UserAccount;
import com.groupone.movierepobackend.services.userAccount.UserAccountService;
import com.groupone.movierepobackend.web.exceptions.UserAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<?> findAllUsers(){
        List<UserAccount> userAccounts = userAccountService.getAllUsers();
        return ResponseEntity.ok().body(userAccounts);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> findUserById(@PathVariable Long userId) throws UserAccountException {
        try {
            UserAccount account = userAccountService.findUserById(userId);
            return ResponseEntity.ok().body(account);
        } catch (UserAccountException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
