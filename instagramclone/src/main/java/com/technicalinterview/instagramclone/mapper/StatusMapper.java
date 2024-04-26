package com.technicalinterview.instagramclone.mapper;

import java.util.Base64;

import org.springframework.stereotype.Component;

import com.technicalinterview.instagramclone.dto.StatusDTO;
import com.technicalinterview.instagramclone.entity.Status;

@Component
public class StatusMapper {
    public static StatusDTO toStatusDTO(Status status) {
        StatusDTO dto = new StatusDTO();
        dto.setId(status.getId());
        dto.setStatusId(status.getStatusId());
        dto.setUserId(status.getUserId());
        dto.setUserName(status.getUserName());
        dto.setTimeStamp(status.getTimeStamp());
        dto.setImageUrl(status.getImageUrl());  // Set the image URL
        return dto;
    }

    public static Status toStatus(StatusDTO dto) {
        Status status = new Status();
        status.setId(dto.getId());
        status.setStatusId(dto.getStatusId());
        status.setUserId(dto.getUserId());
        status.setUserName(dto.getUserName());
        status.setTimeStamp(dto.getTimeStamp());
        status.setImageUrl(dto.getImageUrl());  // Get the image URL
        return status;
    }
}
