package com.technicalinterview.instagramclone.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.technicalinterview.instagramclone.dto.StatusDTO;
import com.technicalinterview.instagramclone.entity.Status;
import com.technicalinterview.instagramclone.mapper.StatusMapper;
import com.technicalinterview.instagramclone.repository.StatusRepo;


@Service
public class StatusService {
     
    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private UserService userService;

    @Autowired 
    private FileService fileService;
    
    public StatusDTO submitDataIntoDB(StatusDTO statusDTO) {
        Status status = StatusMapper.toStatus(statusDTO);
        Status savedStatus = statusRepo.save(status);
        return StatusMapper.toStatusDTO(savedStatus);
    }
	
    public ArrayList<StatusDTO> retrieveStatus() {
        ArrayList<Status> statusList = statusRepo.findAll();
        if (statusList.isEmpty()) {
            // If no statuses are found, return an empty list
            return new ArrayList<>();
        }
        ArrayList<StatusDTO> statusDTOList = new ArrayList<>();

        for (Status status : statusList) {
            StatusDTO statusDTO = StatusMapper.toStatusDTO(status);
            // Retrieve user details, ensure you handle the case where user might not be found
            String userName = userService.displayUserMetaData(status.getUserId()).getUserName();
            if (userName != null) {
                statusDTO.setUserName(userName);
            } else {
                // Fallback or handling for when the user name is not found
                statusDTO.setUserName("Unknown User");
            }
            statusDTOList.add(statusDTO);
        }

        return statusDTOList;
    }

    public StatusDTO handleFileUpload(MultipartFile file, String userId, String userName) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Cannot upload empty file.");
        }
        if (userId == null || userName == null) {
            throw new IllegalArgumentException("User ID and User Name cannot be null");
        }

        // Store the file using FileService and obtain the stored file name
        String fileName = fileService.storeFile(file);

        // Generating download URI for the stored file
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                                                            .path("/files/")
                                                            .path(fileName)
                                                            .toUriString();

        // Creating and saving the Status
        Status status = new Status();
        status.setUserId(userId);
        status.setUserName(userName);
        status.setImageUrl(fileDownloadUri);
        status.setStatusId(generateStatusId());
        status.setTimeStamp(new Timestamp(System.currentTimeMillis()));

        Status savedStatus = statusRepo.save(status);
        return StatusMapper.toStatusDTO(savedStatus);  // Convert entity to DTO
    }
    

    private String generateStatusId() {
        // Generate unique status ID
        return UUID.randomUUID().toString();
    }
    
}
