package com.technicalinterview.instagramclone.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.technicalinterview.instagramclone.entity.Post;
import com.technicalinterview.instagramclone.repository.PostRepo;

@Service
public class PostService {
    
	@Autowired
	PostRepo postRepo;
	
	@Autowired 
	UserService userService;
	
	public Post submitPostToDataBase(Post post) {
		return postRepo.save(post);
	}
	
	public ArrayList<Post> retrivePostFromDB(){
		
		ArrayList<Post> postList = postRepo.findAll();
				
		for(int i=0; i < postList.size(); i++) {
			Post postItem = postList.get(i);
			postItem.setUserName(userService.displayUserMetaData(postItem.getUserId()).getUserName());
			
		}
				
 		return postList;
	}
	
}
