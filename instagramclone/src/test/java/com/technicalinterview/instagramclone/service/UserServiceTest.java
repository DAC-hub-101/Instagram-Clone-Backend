// package com.technicalinterview.instagramclone.service;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;

// import com.technicalinterview.instagramclone.dto.UserDTO;
// import com.technicalinterview.instagramclone.entity.Users;
// import com.technicalinterview.instagramclone.mapper.UserMapper;
// import com.technicalinterview.instagramclone.repository.UserRepo;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

// @ExtendWith(SpringExtension.class)
// public class UserServiceTest {

//     @Mock
//     private UserRepo userRepo;

//     @Mock
//     private UserMapper userMapper; // Inject the mapper

//     @InjectMocks
//     private UserService userService;

//     private UserDTO userDTO;
//     private Users userEntity;

//     @BeforeEach
//     public void setup() {
//         userDTO = new UserDTO("user123", "username", "User Name", "profile.jpg", "password123");
//         userEntity = new Users("user123", "username", "User Name", "password123", "profile.jpg");
//     }

//     @Test
//     public void testSubmitMetaDataOfUser() {
//         // Mock the mapping logic from DTO to entity
//         when(userMapper.toUserEntity(any(UserDTO.class))).thenReturn(userEntity);
        
//         // Mock the repository save method
//         when(userRepo.save(any(Users.class))).thenReturn(userEntity);
//         when(userMapper.toUserDTO(any(Users.class))).thenReturn(userDTO);

//         UserDTO savedUser = userService.submitMetaDataOfUser(userDTO);

//         verify(userMapper, times(1)).toUserEntity(userDTO);
//         verify(userRepo, times(1)).save(userEntity);
//         assert(savedUser.getUserId().equals(userDTO.getUserId()));
//         assert(savedUser.getPassword().equals(userDTO.getPassword()));
//     }

//     @Test
//     public void testDisplayUserMetaData() {
//         // Mock the repository findByUserId method
//         when(userRepo.findByUserId("user123")).thenReturn(userEntity);

//         // Mock the mapping logic from entity to DTO
//         when(userMapper.toUserDTO(userEntity)).thenReturn(userDTO);

//         UserDTO foundUser = userService.displayUserMetaData("user123");

//         verify(userRepo, times(1)).findByUserId("user123");
//         verify(userMapper, times(1)).toUserDTO(userEntity);
//         assert(foundUser.getUserId().equals("user123"));
//         assert(foundUser.getPassword().equals("password123"));
//     }
// }
