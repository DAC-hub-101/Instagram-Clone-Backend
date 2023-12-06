package com.technicalinterview.instagramclone.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.technicalinterview.instagramclone.entity.Post;
import com.technicalinterview.instagramclone.entity.Users;
import com.technicalinterview.instagramclone.repository.PostRepo;
import com.technicalinterview.instagramclone.service.PostService;
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
public class PostServiceTest {

    @Mock
    private PostRepo postRepo;

    @Mock
    private UserService userService;

    @InjectMocks
    private PostService postService;

    private Post post;

    @BeforeEach
    public void setup() {
        post = new Post(1, "post1", "user1", "path/to/post", new Timestamp(System.currentTimeMillis()), 10);
    }

    @Test
    public void testSubmitPostToDataBase() {
        when(postRepo.save(any(Post.class))).thenReturn(post);

        Post savedPost = postService.submitPostToDataBase(post);

        verify(postRepo, times(1)).save(post);
        assert(savedPost.getPostId().equals(post.getPostId()));
    }

    @Test
    public void testRetrivePostFromDB() {
        Users user = new Users(1, "user1", "username", "User Name", "profile.jpg");
        ArrayList<Post> mockPostList = new ArrayList<>();
        mockPostList.add(post);
        
        when(postRepo.findAll()).thenReturn(mockPostList);
        when(userService.displayUserMetaData(anyString())).thenReturn(user);

        ArrayList<Post> postList = postService.retrivePostFromDB();

        verify(postRepo, times(1)).findAll();
        assert(postList.size() == 1);
        assert(postList.get(0).getUserId().equals("user1"));
        assert(postList.get(0).getUserName().equals(user.getUserName()));
    }
}
