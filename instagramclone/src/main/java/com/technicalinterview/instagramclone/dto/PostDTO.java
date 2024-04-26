package com.technicalinterview.instagramclone.dto;

import java.sql.Timestamp;

public class PostDTO {

    private int Id;
    private String postId;
    private String userId;
    private String userName;
    private String imageUrl;
    private Timestamp timeStamp;
    private int likeCount;

       // No-argument constructor
    public PostDTO() {
        
    }

    public PostDTO(int id, String postId, String userId, String userName, String imageUrl, Timestamp timeStamp,
            int likeCount) {
        Id = id;
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.imageUrl = imageUrl;
        this.timeStamp = timeStamp;
        this.likeCount = likeCount;
    }
    public int getId() {
        return Id;
    }
    public String getPostId() {
        return postId;
    }
    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public Timestamp getTimeStamp() {
        return timeStamp;
    }
    public int getLikeCount() {
        return likeCount;
    }
    public void setId(int id) {
        Id = id;
    }
    public void setPostId(String postId) {
        this.postId = postId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
    
}
