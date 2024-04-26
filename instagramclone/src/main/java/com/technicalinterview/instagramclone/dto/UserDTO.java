package com.technicalinterview.instagramclone.dto;

import jakarta.validation.constraints.NotNull;

public class UserDTO {

    private String userId;
    private String userName;
    private String name;
    private String profileImage;
    private String password;

    public UserDTO() {
        // Default constructor code here (if needed)
    }
    
    public UserDTO(String userId, String userName, String name, String profileImage, String password) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.profileImage = profileImage;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getProfileImage() {
        return profileImage;
    }

    
}
