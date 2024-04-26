package com.technicalinterview.instagramclone.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalinterview.instagramclone.dto.CommentsDTO;
import com.technicalinterview.instagramclone.dto.UserDTO;
import com.technicalinterview.instagramclone.entity.Comments;
import com.technicalinterview.instagramclone.entity.Status;
import com.technicalinterview.instagramclone.mapper.CommentsMapper;
import com.technicalinterview.instagramclone.repository.CommentRepo;

@Service
public class CommentsService {
    
    @Autowired
    private CommentRepo commentRepo;
	
    @Autowired
    private UserService userService;

    public CommentsDTO submitCommentToDB(CommentsDTO commentDTO) {
        Comments comment = CommentsMapper.toComments(commentDTO);
        Comments savedComment = commentRepo.save(comment);
        return CommentsMapper.toCommentsDTO(savedComment);
    }
	
    public ArrayList<CommentsDTO> getAllCommentsForDB(String postId) {
        ArrayList<Comments> commentList = commentRepo.findAllByPostId(postId);
        ArrayList<CommentsDTO> commentDTOList = new ArrayList<>();

        for (Comments comment : commentList) {
            CommentsDTO dto = CommentsMapper.toCommentsDTO(comment);
            UserDTO userDTO = userService.displayUserMetaData(dto.getUserId());
            if (userDTO != null) {
                dto.setUserName(userDTO.getUserName());
            } else {
                dto.setUserName("Unknown User"); // Or handle this scenario as per your business logic
            }
            commentDTOList.add(dto);
        }
		
        return commentDTOList;
    }
}

