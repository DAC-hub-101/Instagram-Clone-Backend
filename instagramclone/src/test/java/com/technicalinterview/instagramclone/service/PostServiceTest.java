// package com.technicalinterview.instagramclone.service;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;

// import com.technicalinterview.instagramclone.dto.PostDTO;
// import com.technicalinterview.instagramclone.dto.UserDTO;
// import com.technicalinterview.instagramclone.entity.Post;
// import com.technicalinterview.instagramclone.mapper.PostMapper;
// import com.technicalinterview.instagramclone.repository.PostRepo;

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
// public class PostServiceTest {

//     @Mock
//     private PostRepo postRepo;

//     @Mock
//     private UserService userService;

//     @InjectMocks
//     private PostService postService;

//     private PostDTO postDTO;
//     private UserDTO userDTO;

//     @BeforeEach
//     public void setup() {
//         postDTO = new PostDTO(1, "post1", "user1", "User Name", "path/to/post", new Timestamp(System.currentTimeMillis()), 10);
//         userDTO = new UserDTO("user1", "username", "User Name", "profile.jpg", password);

//         when(userService.displayUserMetaData(anyString())).thenReturn(userDTO);
//     }

//     @Test
//     public void testSubmitPostToDataBase() {
//         Post post = PostMapper.toPost(postDTO);
//         when(postRepo.save(any(Post.class))).thenReturn(post);

//         PostDTO savedPostDTO = postService.submitPostToDataBase(postDTO);

//         verify(postRepo, times(1)).save(any(Post.class));
//         assert(savedPostDTO.getPostId().equals(postDTO.getPostId()));
//     }

//     @Test
//     public void testRetrivePostFromDB() {
//         Post post = PostMapper.toPost(postDTO);
//         ArrayList<Post> mockPostList = new ArrayList<>(Arrays.asList(post));
        
//         when(postRepo.findAll()).thenReturn(mockPostList);

//         ArrayList<PostDTO> postDTOList = postService.retrivePostFromDB();

//         verify(postRepo, times(1)).findAll();
//         assert(postDTOList.size() == 1);
//         assert(postDTOList.get(0).getUserId().equals("user1"));
//         assert(postDTOList.get(0).getUserName().equals(userDTO.getUserName()));
//     }
// }
