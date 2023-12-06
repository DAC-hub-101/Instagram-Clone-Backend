package com.technicalinterview.instagramclone.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import com.technicalinterview.instagramclone.entity.Comments;
import com.technicalinterview.instagramclone.entity.Users;
import com.technicalinterview.instagramclone.repository.CommentRepo;
import com.technicalinterview.instagramclone.service.CommentsService;
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
public class CommentServiceTest {

    @Mock
    private CommentRepo commentRepo;

    @Mock
    private UserService userService;

    @InjectMocks
    private CommentsService commentsService;

    private Comments comment;

    @BeforeEach
    public void setup() {
        comment = new Comments(1, "comment1", "user1", "post1", new Timestamp(System.currentTimeMillis()), "Nice post!");
    }

    @Test
    public void testSubmitCommentToDB() {
        when(commentRepo.save(any(Comments.class))).thenReturn(comment);

        Comments savedComment = commentsService.submitCommentToDB(comment);

        verify(commentRepo, times(1)).save(comment);
        assert(savedComment.getCommentId().equals(comment.getCommentId()));
    }

    @Test
    public void testGetAllCommentsForDB() {
        Users user = new Users(1, "user1", "username", "User Name", "profile.jpg");
        ArrayList<Comments> mockCommentList = new ArrayList<>(Arrays.asList(comment));
        
        when(commentRepo.findAllByPostId(anyString())).thenReturn(mockCommentList);
        when(userService.displayUserMetaData(anyString())).thenReturn(user);

        ArrayList<Comments> commentList = commentsService.getAllCommentsForDB("post1");

        verify(commentRepo, times(1)).findAllByPostId("post1");
        assert(commentList.size() == 1);
        assert(commentList.get(0).getUserId().equals("user1"));
        assert(commentList.get(0).getUserName().equals(user.getUserName()));
    }
}
