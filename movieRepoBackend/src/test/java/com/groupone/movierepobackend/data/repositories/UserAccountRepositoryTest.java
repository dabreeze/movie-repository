package com.groupone.movierepobackend.data.repositories;

import com.groupone.movierepobackend.data.models.UserAccount;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserAccountRepositoryTest {


    @Autowired
    UserAccountRepository userAccountRepository;

    @BeforeEach
    void setUp() {

    }


    @Test
    @DisplayName("Create a new User Account Test")
    void createUserAccountTest(){
        //creating a user object
        UserAccount newUser = new UserAccount();
        newUser.setFirstName("John");
        newUser.setLastName("Doe");
        newUser.setEmail("johnDoe@gmail.com");
        newUser.setPassword("123444");

        //save user object
        userAccountRepository.save(newUser);

        //assert
        assertThat(newUser.getId()).isNotNull();

        log.info("Account created -> :: {}", newUser);

    }
}