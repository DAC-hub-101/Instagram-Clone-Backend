package com.technicalinterview.instagramclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalinterview.instagramclone.dto.LoginDTO;
import com.technicalinterview.instagramclone.dto.UserDTO;
import com.technicalinterview.instagramclone.entity.Users;
import com.technicalinterview.instagramclone.mapper.UserMapper;
import com.technicalinterview.instagramclone.repository.UserRepo;

@Service
public class UserService {
	 
	@Autowired 
	UserRepo userRepo;
	
	@Autowired
	UserMapper userMapper; // Inject the mapper
	
    public UserDTO submitMetaDataOfUser(UserDTO userDTO) {
        Users userEntity = userMapper.toUserEntity(userDTO);
        Users savedUser = userRepo.save(userEntity);
        return userMapper.toUserDTO(savedUser);
    }
     
    public UserDTO displayUserMetaData(String userId) {
        Users userEntity = userRepo.findByUserId(userId);
        if (userEntity != null) {
            return userMapper.toUserDTO(userEntity);
        } else {
            // Handle the case where the user is not found
            return null;  // Return null or throw a custom exception that can be handled globally
        }
    }
    
    public UserDTO authenticateUser(LoginDTO loginDTO) {
        Users userEntity = userRepo.findByUserName(loginDTO.getEmailId());
        if (userEntity != null && userEntity.getPassword().trim().equals(loginDTO.getPassword().trim())) {
            return userMapper.toUserDTO(userEntity);  // Convert and return UserDTO
        }
        return null;  // Return null if authentication fails
    }
    
}
