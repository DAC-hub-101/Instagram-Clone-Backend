package com.technicalinterview.instagramclone.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="Status")
public class Status {
    @Id
    @GeneratedValue
    private int id;
    
    private String statusId;
    private String userId;
    private String userName;
    private Timestamp timeStamp;
    
	private String imageUrl;  // URL to the image stored locally
	public Status() {
		super();
	}
	
	public Status(int id, String statusId, String userId, String path, Timestamp timeStamp) {
		super();
		this.id = id;
		this.statusId = statusId;
		this.userId = userId;
		this.timeStamp = timeStamp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timestamp2) {
		this.timeStamp = timestamp2;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
    
	public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
