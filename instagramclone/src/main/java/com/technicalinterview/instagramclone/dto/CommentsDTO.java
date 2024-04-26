package com.technicalinterview.instagramclone.dto;

import java.sql.Timestamp;

public class CommentsDTO {

    private int id;
    private String commentId;
    private String userId;
    private String postId;
    private Timestamp timeStamp;
    private String comment;
    private String userName;
    
    public CommentsDTO(int id, String commentId, String userId, String postId, Timestamp timeStamp, String comment,
            String userName) {

        this.id = id;
        this.commentId = commentId;
        this.userId = userId;
        this.postId = postId;
        this.timeStamp = timeStamp;
        this.comment = comment;
        this.userName = userName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public String getCommentId() {
        return commentId;
    }

    public String getUserId() {
        return userId;
    }

    public String getPostId() {
        return postId;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public String getComment() {
        return comment;
    }

    public String getUserName() {
        return userName;
    }

}
