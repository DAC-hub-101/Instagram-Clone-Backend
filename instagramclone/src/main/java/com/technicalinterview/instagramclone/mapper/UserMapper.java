package com.technicalinterview.instagramclone.mapper;

import com.technicalinterview.instagramclone.dto.LoginDTO;
import com.technicalinterview.instagramclone.dto.UserDTO;
import com.technicalinterview.instagramclone.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toUserDTO(Users user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());
        userDTO.setName(user.getName());
        userDTO.setProfileImage(user.getProfileImage());
        return userDTO;
    }

    public Users toUserEntity(UserDTO userDTO) {
        Users user = new Users();
        user.setUserId(userDTO.getUserId());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setProfileImage(userDTO.getProfileImage());
        return user;
    }

    // Conversion methods for LoginDTO
    public UserDTO toUserDTO(LoginDTO loginDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(loginDTO.getEmailId()); // Assuming emailId is used as the username
        userDTO.setPassword(loginDTO.getPassword());
        return userDTO;
    }

    public LoginDTO toLoginDTO(UserDTO userDTO) {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmailId(userDTO.getUserName()); // Assuming emailId is used as the username
        loginDTO.setPassword(userDTO.getPassword());
        return loginDTO;
    }
}
