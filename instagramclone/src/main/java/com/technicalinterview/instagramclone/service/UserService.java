package com.technicalinterview.instagramclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalinterview.instagramclone.entity.Users;
import com.technicalinterview.instagramclone.repository.UserRepo;

@Service
public class UserService {
	 
	 @Autowired 
	 UserRepo userRepo;
	 
     public Users submitMetaDataOfUser(Users user) {
    	 return userRepo.save(user);
     }
     
     public Users displayUserMetaData(String userid) {
    	 return userRepo.findByUserId(userid);
     }
}
