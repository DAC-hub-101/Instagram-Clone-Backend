package com.technicalinterview.instagramclone.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.technicalinterview.instagramclone.entity.Users;

@Repository
public interface UserRepo extends CrudRepository<Users, Integer>{
	
    Users save(Users user);
    Users findByUserId(String userId);
    Users findByUserName(String userName);
}
