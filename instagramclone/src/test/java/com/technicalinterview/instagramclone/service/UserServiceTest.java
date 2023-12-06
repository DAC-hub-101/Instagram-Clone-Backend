package com.technicalinterview.instagramclone.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.technicalinterview.instagramclone.entity.Users;
import com.technicalinterview.instagramclone.repository.UserRepo;
import com.technicalinterview.instagramclone.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserService userService;

    private Users user;

    @BeforeEach
    public void setup() {
        user = new Users(1, "user123", "username", "User Name", "profile.jpg");
    }

    @Test
    public void testSubmitMetaDataOfUser() {
        when(userRepo.save(any(Users.class))).thenReturn(user);

        Users savedUser = userService.submitMetaDataOfUser(user);

        verify(userRepo, times(1)).save(user);
        assert(savedUser.getUserId().equals(user.getUserId()));
    }

    @Test
    public void testDisplayUserMetaData() {
        when(userRepo.findByUserId("user123")).thenReturn(user);

        Users foundUser = userService.displayUserMetaData("user123");

        verify(userRepo, times(1)).findByUserId("user123");
        assert(foundUser.getUserId().equals("user123"));
    }

}
