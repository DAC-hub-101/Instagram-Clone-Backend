package com.technicalinterview.instagramclone.controller;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technicalinterview.instagramclone.dto.LoginDTO;
import com.technicalinterview.instagramclone.dto.UserDTO;
import com.technicalinterview.instagramclone.mapper.UserMapper;
import com.technicalinterview.instagramclone.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @PostMapping("/register")
    public ResponseEntity<UserDTO> submitUser(@Valid @RequestBody UserDTO userDTO) {
        System.out.println("Received in Controller - Email: " + userDTO.getUserName() + ", Name: " + userDTO.getName() + ", Username: " + userDTO.getUserName() + ", Password: " + userDTO.getPassword());
        try {
            UserDTO savedUser = userService.submitMetaDataOfUser(userDTO);
            return ResponseEntity.ok(savedUser);  // Send 200 OK with user data
        } catch (Exception e) {
            System.out.println("Error saving user: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Send 500 Internal Server Error
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        UserDTO userDTO = userService.authenticateUser(loginDTO);
        if (userDTO != null) {
            return ResponseEntity.ok()
                                 .contentType(MediaType.APPLICATION_JSON)
                                 .body(userDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .contentType(MediaType.APPLICATION_JSON)
                                 .body("{\"error\": \"Invalid credentials\"}");
        }
    }

    @GetMapping("/{userid}")
    public ResponseEntity<?> getUserDetails(@PathVariable("userid") String userId) {
        try {
            UserDTO userDTO = userService.displayUserMetaData(userId);
            if (userDTO != null) {
                return ResponseEntity.ok(userDTO);
            } else {
                // Not found
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            // Handle unexpected exceptions
            return ResponseEntity.internalServerError().body("An error occurred: " + ex.getMessage());
        }
    }
}

