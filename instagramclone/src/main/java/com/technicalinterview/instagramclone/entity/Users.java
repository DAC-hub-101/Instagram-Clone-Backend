package com.technicalinterview.instagramclone.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity(name="Users")
public class Users {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
  	private String userId;


    @NotNull
    private String userName;
    private String name;
	private String password;
    private String profileImage;
    
	public Users() {
		super();
	}
	
	public Users(String userId, String userName, String name, String password, String profileImage) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.profileImage = profileImage;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
