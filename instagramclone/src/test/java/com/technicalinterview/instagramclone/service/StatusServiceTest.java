package com.technicalinterview.instagramclone.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import com.technicalinterview.instagramclone.entity.Status;
import com.technicalinterview.instagramclone.entity.Users;
import com.technicalinterview.instagramclone.repository.StatusRepo;
import com.technicalinterview.instagramclone.service.StatusService;
import com.technicalinterview.instagramclone.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

@ExtendWith(SpringExtension.class)
public class StatusServiceTest {

    @Mock
    private StatusRepo statusRepo;

    @Mock
    private UserService userService;

    @InjectMocks
    private StatusService statusService;

    private Status status;

    @BeforeEach
    public void setup() {
        status = new Status(1, "status1", "user1", "path/to/status", new Timestamp(System.currentTimeMillis()));
    }

    @Test
    public void testSubmitDataIntoDB() {
        when(statusRepo.save(any(Status.class))).thenReturn(status);

        Status savedStatus = statusService.submitDataIntoDB(status);

        verify(statusRepo, times(1)).save(status);
        assert(savedStatus.getStatusId().equals(status.getStatusId()));
    }

    @Test
    public void testRetrieveStatus() {
        Users user = new Users(1, "user1", "username", "User Name", "profile.jpg");
        ArrayList<Status> mockStatusList = new ArrayList<>();
        mockStatusList.add(status);
        
        when(statusRepo.findAll()).thenReturn(mockStatusList);
        when(userService.displayUserMetaData(anyString())).thenReturn(user);

        ArrayList<Status> statusList = statusService.retrieveStatus();

        verify(statusRepo, times(1)).findAll();
        assert(statusList.size() == 1);
        assert(statusList.get(0).getUserId().equals("user1"));
        assert(statusList.get(0).getUserName().equals(user.getUserName()));
    }

}
