package com.technicalinterview.instagramclone.dto;

public class LoginDTO {
    private String emailId;
    private String password;

    public LoginDTO() {
        // Default constructor code here (if needed)
    }

    // // Overriding toString() to print emailIdDTO and passwordDTO
    // @Override
    // public String toString() {
    //     return "LoginDTO{" +
    //            "emailIdDTO='" + emailId + '\'' +
    //            ", passwordDTO='" + password + '\'' +
    //            '}';
    // }

    // getters and setters
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}
