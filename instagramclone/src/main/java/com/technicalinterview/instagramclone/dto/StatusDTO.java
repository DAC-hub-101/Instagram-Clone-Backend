package com.technicalinterview.instagramclone.dto;

import java.sql.Timestamp;

import org.apache.tomcat.util.codec.binary.Base64;

public class StatusDTO {

    private int id;
    private String statusId;
    private String userId;
    private String imageUrl;  // URL of the image
    private String userName;
    private Timestamp timeStamp;
    

    public StatusDTO() {
    }

    public StatusDTO(int id, String statusId, String userId, String imageUrl, String userName, Timestamp timeStamp) {
        this.id = id;
        this.statusId = statusId;
        this.userId = userId;
        this.imageUrl = imageUrl;
        this.userName = userName;
        this.timeStamp = timeStamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public String getStatusId() {
        return statusId;
    }
  
    public String getUserId() {
        return userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

}
