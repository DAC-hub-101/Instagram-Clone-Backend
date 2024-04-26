// package com.technicalinterview.instagramclone.service;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.anyString;
// import static org.mockito.Mockito.*;

// import com.technicalinterview.instagramclone.dto.CommentsDTO;
// import com.technicalinterview.instagramclone.dto.UserDTO;
// import com.technicalinterview.instagramclone.entity.Comments;
// import com.technicalinterview.instagramclone.entity.Users;
// import com.technicalinterview.instagramclone.mapper.CommentsMapper;
// import com.technicalinterview.instagramclone.repository.CommentRepo;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

// import java.sql.Timestamp;
// import java.util.ArrayList;
// import java.util.Arrays;


// @ExtendWith(SpringExtension.class)
// public class CommentServiceTest {

//     @Mock
//     private CommentRepo commentRepo;

//     @Mock
//     private UserService userService;

//     @InjectMocks
//     private CommentsService commentsService;

//     private CommentsDTO commentDTO;
//     private UserDTO userDTO;

//     @BeforeEach
//     public void setup() {
//         commentDTO = new CommentsDTO(1, "comment1", "user1", "post1", new Timestamp(System.currentTimeMillis()), "Nice post!", "User Name");

//         // Create and set up a UserDTO object based on your UserDTO class
//         userDTO = new UserDTO();
//         userDTO.setUserId("user1");
//         userDTO.setUserName("User Name"); // Update the username to match the expected value
//         userDTO.setName("User Name");
//         userDTO.setProfileImage("profile.jpg");

//         when(userService.displayUserMetaData(anyString())).thenReturn(userDTO);
//     }

//     @Test
//     public void testSubmitCommentToDB() {
//         Comments comment = CommentsMapper.toComments(commentDTO);
//         when(commentRepo.save(any(Comments.class))).thenReturn(comment);

//         CommentsDTO savedCommentDTO = commentsService.submitCommentToDB(commentDTO);

//         verify(commentRepo, times(1)).save(any(Comments.class));
//         assert(savedCommentDTO.getCommentId().equals(commentDTO.getCommentId()));
//     }

//     @Test
//     public void testGetAllCommentsForDB() {
//         Comments comment = CommentsMapper.toComments(commentDTO);
//         ArrayList<Comments> mockCommentList = new ArrayList<>(Arrays.asList(comment));
        
//         when(commentRepo.findAllByPostId(anyString())).thenReturn(mockCommentList);

//         ArrayList<CommentsDTO> commentDTOList = commentsService.getAllCommentsForDB("post1");

//         verify(commentRepo, times(1)).findAllByPostId("post1");
//         assertEquals(1, commentDTOList.size());
//         assertEquals("user1", commentDTOList.get(0).getUserId());
//         assertEquals(userDTO.getName(), commentDTOList.get(0).getUserName());
//     }
// }

