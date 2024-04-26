package com.technicalinterview.instagramclone.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.technicalinterview.instagramclone.dto.StatusDTO;
import com.technicalinterview.instagramclone.service.StatusService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/status")
public class StatusController {
    
    @Autowired
    private StatusService statusService;

    private static final Logger logger = LoggerFactory.getLogger(StatusController.class);

    /**
     * Uploads a status with an associated file for a specific user.
     * 
     * @param file the file to upload
     * @param userId the user ID of the user uploading the status
     * @param userName the username of the user uploading the status
     * @return ResponseEntity representing the outcome of the upload operation
     */
    @PostMapping("/upload")
    public ResponseEntity<?> uploadStatus(@RequestParam("file") MultipartFile file, 
                                          @RequestParam("userId") String userId, 
                                          @RequestParam("userName") String userName) {
        try {
            logger.info("Received file upload request for user: {}", userName);
            StatusDTO statusDTO = statusService.handleFileUpload(file, userId, userName);
            return ResponseEntity.ok(statusDTO);
        } catch (IllegalArgumentException e) {
            logger.error("Validation error: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Validation error: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error uploading file", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload status: " + e.getMessage());
        }
    }

    /**
     * Retrieves all statuses.
     * 
     * @return A list of all status DTOs
     */
    @GetMapping("/get")
    public ResponseEntity<ArrayList<StatusDTO>> getAllStatus() {
        try {
            ArrayList<StatusDTO> statuses = statusService.retrieveStatus();
            if (statuses.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(statuses);
        } catch (Exception e) {
            logger.error("Error retrieving statuses", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
