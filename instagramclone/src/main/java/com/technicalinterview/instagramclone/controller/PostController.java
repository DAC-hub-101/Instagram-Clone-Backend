package com.technicalinterview.instagramclone.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.technicalinterview.instagramclone.dto.PostDTO;
import com.technicalinterview.instagramclone.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/post")
public class PostController {
    
    @Autowired
    private PostService postService;

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    /**
     * Endpoint to upload a post along with an optional file.
     * @param file Optional file to be uploaded with the post.
     * @param postDTO JSON body of the post data.
     * @return ResponseEntity with the result of the operation.
     */
    @PostMapping("/upload")
    public ResponseEntity<?> submitUserPost(@RequestParam(required = false) MultipartFile file, 
                                            @RequestParam("post") String postJson) { // Changed to @RequestParam for simplicity
        try {
            // Manually parse the JSON string to PostDTO
            PostDTO postDTO = new ObjectMapper().readValue(postJson, PostDTO.class);
            
            PostDTO savedPostDTO = postService.submitPostToDatabase(file, postDTO);
            return ResponseEntity.ok(savedPostDTO);
        } catch (JsonProcessingException e) {
            logger.error("JSON parsing error: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid JSON data");
        } catch (Exception e) {
            logger.error("Error uploading post: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading post: " + e.getMessage());
        }
    }

    @GetMapping("")
    public ArrayList<PostDTO> getAllPost() {
        return postService.retrievePostsFromDB();
    }
}
