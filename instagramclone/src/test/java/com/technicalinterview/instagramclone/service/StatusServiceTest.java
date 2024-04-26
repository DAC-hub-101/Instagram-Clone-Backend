// package com.technicalinterview.instagramclone.service;

// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.anyList;
// import static org.mockito.ArgumentMatchers.anyString;
// import static org.mockito.Mockito.*;

// import com.technicalinterview.instagramclone.dto.StatusDTO;
// import com.technicalinterview.instagramclone.entity.Status;
// import com.technicalinterview.instagramclone.mapper.StatusMapper;
// import com.technicalinterview.instagramclone.service.StatusService;
// import com.technicalinterview.instagramclone.repository.StatusRepo;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import java.sql.Timestamp;
// import java.util.ArrayList;
// import java.util.List;

// public class StatusServiceTest {

//     @Mock
//     private StatusRepo statusRepo;

//     @Mock
//     private UserService userService;

//     @Mock
//     private StatusMapper statusMapper;

//     @InjectMocks
//     private StatusService statusService;

//     private StatusDTO statusDTO;
//     private Status statusEntity;
//     private List<Status> statusEntityList;

//     @BeforeEach
//     public void setUp() {
//         MockitoAnnotations.openMocks(this);

//         // Create a sample StatusDTO
//         statusDTO = new StatusDTO(1, "status1", "user1", "path/to/status", "User Name", new Timestamp(System.currentTimeMillis()));

//         // Create a sample Status entity
//         statusEntity = new Status();
//         statusEntity.setId(1);
//         statusEntity.setStatusId("status1");
//         statusEntity.setUserId("user1");
//         statusEntity.setPath("path/to/status");
//         statusEntity.setUserName("User Name");
//         statusEntity.setTimeStamp(new Timestamp(System.currentTimeMillis()));

//         // Create a list of Status entities
//         statusEntityList = new ArrayList<>();
//         statusEntityList.add(statusEntity);

//         // Stub the behavior of userService.displayUserMetaData() method
//         when(userService.displayUserMetaData(anyString())).thenReturn(statusDTO);

//         // Stub the behavior of statusMapper methods
//         when(statusMapper.toStatus(any(StatusDTO.class))).thenReturn(statusEntity);
//         when(statusMapper.toStatusDTO(any(Status.class))).thenReturn(statusDTO);
//     }

//     @Test
//     public void testSubmitDataIntoDB() {
//         // Stub the behavior of statusRepo.save() method
//         when(statusRepo.save(any(Status.class))).thenReturn(statusEntity);

//         StatusDTO savedStatusDTO = statusService.submitDataIntoDB(statusDTO);

//         verify(statusRepo, times(1)).save(any(Status.class));
//         assertNotNull(savedStatusDTO); // Check that the returned object is not null
//         assertEquals(statusEntity.getId(), savedStatusDTO.getId()); // Check that the ID matches
//     }

//     @Test
//     public void testRetrieveStatus() {
//         // Stub the behavior of statusRepo.findAll() method using anyList() matcher
//         when(statusRepo.findAll()).thenReturn(anyList());

//         ArrayList<StatusDTO> statusDTOList = statusService.retrieveStatus();

//         verify(statusRepo, times(1)).findAll();
//         assertFalse(statusDTOList.isEmpty()); // Check that the list is not empty
//         assertEquals(1, statusDTOList.size()); // Check the size of the list
//     }
// }
