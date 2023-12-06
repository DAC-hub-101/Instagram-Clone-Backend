package com.technicalinterview.instagramclone.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.technicalinterview.instagramclone.entity.Post;


@Repository
public interface PostRepo extends CrudRepository<Post, Integer> {
    Post save(Post post);
    ArrayList<Post> findAll();
    
    // Custom query method to search posts by username
    ArrayList<Post> findByUserName(String username);
}
