// package com.technicalinterview.instagramclone.controller;

// import static org.mockito.Mockito.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.technicalinterview.instagramclone.dto.CommentsDTO;
// import com.technicalinterview.instagramclone.service.CommentsService;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mock;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.web.servlet.MockMvc;

// import java.sql.Timestamp;
// import java.util.ArrayList;

// @ExtendWith(SpringExtension.class)
// @WebMvcTest(CommentController.class)
// public class CommentControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     private CommentsService commentsService;

//     private ObjectMapper objectMapper = new ObjectMapper();

//     @Test
//     public void testSubmitComment() throws Exception {
//         CommentsDTO commentDTO = new CommentsDTO(1, "comment1", "user1", "post1", new Timestamp(System.currentTimeMillis()), "Nice post!", "User Name");
//         when(commentsService.submitCommentToDB(any(CommentsDTO.class))).thenReturn(commentDTO);

//         mockMvc.perform(post("/comments")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(commentDTO)))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.commentId").value(commentDTO.getCommentId()));

//         verify(commentsService, times(1)).submitCommentToDB(any(CommentsDTO.class));
//     }

//     @Test
//     public void testGetCommentsForPost() throws Exception {
//         ArrayList<CommentsDTO> commentsDTOList = new ArrayList<>();
//         commentsDTOList.add(new CommentsDTO(1, "comment1", "user1", "post1", new Timestamp(System.currentTimeMillis()), "Nice post!", "User Name"));
//         when(commentsService.getAllCommentsForDB("post1")).thenReturn(commentsDTOList);

//         mockMvc.perform(get("/comments/post1"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$[0].commentId").value("comment1"));

//         verify(commentsService, times(1)).getAllCommentsForDB("post1");
//     }
// }
