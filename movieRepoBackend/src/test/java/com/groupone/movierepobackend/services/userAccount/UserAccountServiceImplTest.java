package com.groupone.movierepobackend.services.userAccount;

import com.groupone.movierepobackend.data.dtos.UserAccountRequestDto;
import com.groupone.movierepobackend.data.dtos.UserAccountResponseDto;
import com.groupone.movierepobackend.data.models.UserAccount;
import com.groupone.movierepobackend.data.repositories.UserAccountRepository;
import com.groupone.movierepobackend.web.exceptions.UserAccountException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserAccountServiceImplTest {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    UserAccountService userAccountService;


    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Create a new User Account Test")
    void createUserTest() throws UserAccountException {
        UserAccountRequestDto userAccountRequestDto = new UserAccountRequestDto();
        userAccountRequestDto.setFirstName("Tosin");
        userAccountRequestDto.setLastName("Akin");
        userAccountRequestDto.setEmail("takin@gmail.com");
        userAccountRequestDto.setPassword("23451");

        UserAccountResponseDto newUserAccount = userAccountService.createMovieUser(userAccountRequestDto);
        assertThat(newUserAccount).isNotNull();
        assertThat(newUserAccount.getEmail()).isEqualTo("takin@gmail.com");
//        assertThat(newUserAccount.getFirstName()).isEqualTo("Tosin");
//        assertThat(newUserAccount.getLastName()).isEqualTo("Akin");
        log.info("New User Created -> :: {}", newUserAccount);

    }

    @Test
    @DisplayName("Find all users test")
    void getAllUsersTest() throws UserAccountException {
        List<UserAccount> accounts = userAccountService.getAllUsers();
        assertThat(accounts).isNotNull();

        //create another user
        UserAccountRequestDto userAccountRequestDto = new UserAccountRequestDto();
        userAccountRequestDto.setFirstName("Jane");
        userAccountRequestDto.setLastName("Doe");
        userAccountRequestDto.setEmail("janeDoe@gmail.com");
        userAccountRequestDto.setPassword("11551");

        UserAccountResponseDto myUserAccount = userAccountService.createMovieUser(userAccountRequestDto);
        assertThat(myUserAccount).isNotNull();
        assertThat(accounts).size().isEqualTo(7);



    }
}