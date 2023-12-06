package com.technicalinterview.instagramclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technicalinterview.instagramclone.entity.Users;
import com.technicalinterview.instagramclone.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("")
     private Users submitUser(@RequestBody Users users) {
		return userService.submitMetaDataOfUser(users);
     }
	
	@GetMapping("/{userid}")
	private Users getUserDetails(@PathVariable("userid") String userId) {
		return userService.displayUserMetaData(userId);
		
	}
}
