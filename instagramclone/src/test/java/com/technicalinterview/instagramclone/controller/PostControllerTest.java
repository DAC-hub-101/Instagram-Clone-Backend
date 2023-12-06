package com.technicalinterview.instagramclone.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.technicalinterview.instagramclone.entity.Post;
import com.technicalinterview.instagramclone.service.PostService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.util.ArrayList;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testSubmitUserPost() throws Exception {
        Post post = new Post(1, "postId1", "user1", "path/to/post", new Timestamp(System.currentTimeMillis()), 10);
        when(postService.submitPostToDataBase(any(Post.class))).thenReturn(post);

        mockMvc.perform(post("/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.postId").value(post.getPostId()));

        verify(postService, times(1)).submitPostToDataBase(any(Post.class));
    }

    @Test
    public void testGetAllPost() throws Exception {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "postId1", "user1", "path/to/post", new Timestamp(System.currentTimeMillis()), 10));
        when(postService.retrivePostFromDB()).thenReturn(posts);

        mockMvc.perform(get("/post"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].postId").value("postId1"));

        verify(postService, times(1)).retrivePostFromDB();
    }
}
