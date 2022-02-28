package com.groupone.movierepobackend.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupone.movierepobackend.data.dtos.UserAccountRequestDto;
import com.groupone.movierepobackend.data.dtos.UserAccountResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class UserAccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Create UserAccount controller test")
    void createUserAccount() throws Exception {

        UserAccountRequestDto requestDto = new UserAccountRequestDto();
        requestDto.setFirstName("Toye");
        requestDto.setLastName("Israel");
        requestDto.setEmail("ToyeIs@gmail.com");
        requestDto.setPassword("2348930");

        String requestBody = objectMapper.writeValueAsString(requestDto);

        mockMvc.perform(post("/api/account")
                .contentType("application/json")
                .content((requestBody)))
                .andExpect(status().is(200))
                .andDo(print());
    }

    @Test
    @DisplayName("Get all users API test")
    void findAllUsersTest() throws Exception {
        mockMvc.perform(get("/api/accaount")
                .contentType("application/json"))
                .andExpect(status().is(200))
                .andDo(print());
    }
}