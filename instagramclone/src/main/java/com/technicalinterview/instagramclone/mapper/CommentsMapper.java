package com.technicalinterview.instagramclone.mapper;

import org.springframework.stereotype.Component;

import com.technicalinterview.instagramclone.dto.CommentsDTO;
import com.technicalinterview.instagramclone.entity.Comments;

@Component
public class CommentsMapper {

    public static CommentsDTO toCommentsDTO(Comments comment) {
        return new CommentsDTO(
            comment.getId(),
            comment.getCommentId(),
            comment.getUserId(),
            comment.getPostId(),
            comment.getTimeStamp(),
            comment.getComment(),
            comment.getUserName()
        );
    }

    public static Comments toComments(CommentsDTO dto) {
        Comments comment = new Comments();
        comment.setId(dto.getId());
        comment.setCommentId(dto.getCommentId());
        comment.setUserId(dto.getUserId());
        comment.setPostId(dto.getPostId());
        comment.setTimeStamp(dto.getTimeStamp());
        comment.setComment(dto.getComment());
        comment.setUserName(dto.getUserName());
        return comment;
    }
}
