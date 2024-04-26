package com.technicalinterview.instagramclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.technicalinterview.instagramclone.dto.PostDTO;
import com.technicalinterview.instagramclone.dto.UserDTO;
import com.technicalinterview.instagramclone.entity.Post;
import com.technicalinterview.instagramclone.mapper.PostMapper;
import com.technicalinterview.instagramclone.repository.PostRepo;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class PostService {
    
    @Autowired
    private PostRepo postRepo;
	
    @Autowired 
    private UserService userService;

    @Autowired
    private FileService fileService; // Inject FileService to handle file uploads

    public PostDTO submitPostToDatabase(MultipartFile file, PostDTO postDTO) {
        try {
            // Handle the file upload first
            if (file != null && !file.isEmpty()) {
                String filename = fileService.storeFile(file);
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                                                                    .path("/files/")
                                                                    .path(filename)
                                                                    .toUriString();
                postDTO.setImageUrl(fileDownloadUri);
            }
            Post post = PostMapper.toPost(postDTO);
            Post savedPost = postRepo.save(post);
            return PostMapper.toPostDTO(savedPost);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save post: " + e.getMessage(), e);
        }
    }
	
    public ArrayList<PostDTO> retrievePostsFromDB() {
        ArrayList<Post> postList = postRepo.findAll();
        ArrayList<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : postList) {
            PostDTO dto = PostMapper.toPostDTO(post);
            UserDTO userDTO = userService.displayUserMetaData(dto.getUserId());
            dto.setUserName(userDTO != null ? userDTO.getUserName() : "Unknown User");
            postDTOList.add(dto);
        }
        Collections.sort(postDTOList, (a, b) -> b.getId() - a.getId());
        return postDTOList;
    }
}
