// package com.technicalinterview.instagramclone.controller;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.technicalinterview.instagramclone.dto.UserDTO;
// import com.technicalinterview.instagramclone.service.UserService;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.web.servlet.MockMvc;

// @ExtendWith(SpringExtension.class)
// @WebMvcTest(UserController.class)
// public class UserControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     private UserService userService;

//     private ObjectMapper objectMapper = new ObjectMapper();

//     @Test
//     public void testSubmitUser() throws Exception {
//         UserDTO userDTO = new UserDTO("user1", "username1", "Name1", "image1.jpg");
//         when(userService.submitMetaDataOfUser(any(UserDTO.class))).thenReturn(userDTO);

//         mockMvc.perform(post("/users")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(userDTO)))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.userId").value(userDTO.getUserId()));

//         verify(userService, times(1)).submitMetaDataOfUser(any(UserDTO.class));
//     }

//     @Test
//     public void testGetUserDetails() throws Exception {
//         UserDTO userDTO = new UserDTO("user1", "username1", "Name1", "image1.jpg");
//         when(userService.displayUserMetaData("user1")).thenReturn(userDTO);

//         mockMvc.perform(get("/users/user1"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.userId").value("user1"));

//         verify(userService, times(1)).displayUserMetaData("user1");
//     }
// }
