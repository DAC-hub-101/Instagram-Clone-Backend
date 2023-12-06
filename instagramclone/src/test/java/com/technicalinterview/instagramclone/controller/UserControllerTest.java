package com.technicalinterview.instagramclone.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.technicalinterview.instagramclone.entity.Users;
import com.technicalinterview.instagramclone.service.UserService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testSubmitUser() throws Exception {
        Users user = new Users(1, "user1", "username1", "Name1", "image1.jpg");
        when(userService.submitMetaDataOfUser(any(Users.class))).thenReturn(user);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(user.getUserId()));

        verify(userService, times(1)).submitMetaDataOfUser(any(Users.class));
    }

    @Test
    public void testGetUserDetails() throws Exception {
        Users user = new Users(1, "user1", "username1", "Name1", "image1.jpg");
        when(userService.displayUserMetaData("user1")).thenReturn(user);

        mockMvc.perform(get("/users/user1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value("user1"));

        verify(userService, times(1)).displayUserMetaData("user1");
    }
}
