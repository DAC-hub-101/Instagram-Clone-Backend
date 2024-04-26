package com.technicalinterview.instagramclone.mapper;

import org.springframework.stereotype.Component;

import com.technicalinterview.instagramclone.dto.PostDTO;
import com.technicalinterview.instagramclone.entity.Post;


@Component
public class PostMapper {

    public static PostDTO toPostDTO(Post post) {
        return new PostDTO(
            post.getId(),
            post.getPostId(),
            post.getUserId(),
            post.getUserName(),
            post.getImageUrl(),
            post.getTimeStamp(),
            post.getLikeCount()
        );
    }

    public static Post toPost(PostDTO dto) {
        Post post = new Post();
        post.setId(dto.getId());
        post.setPostId(dto.getPostId());
        post.setUserId(dto.getUserId());
        post.setUserName(dto.getUserName());
        post.setImageUrl(dto.getImageUrl());
        post.setTimeStamp(dto.getTimeStamp());
        post.setLikeCount(dto.getLikeCount());
        return post;
    }
}
