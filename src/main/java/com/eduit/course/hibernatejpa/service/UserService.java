package com.eduit.course.hibernatejpa.service;

import java.util.Date;

import com.eduit.course.hibernatejpa.db.entity.UserEntity;

public interface UserService {

	UserEntity createUser(String username, String firstName, String lastName, String email, String password, Date dateCreated);
	
	UserEntity login(String username, String password);
	
}
