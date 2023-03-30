package com.eduit.course.hibernatejpa.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eduit.course.hibernatejpa.db.entity.UserEntity;
import com.eduit.course.hibernatejpa.db.repository.CustomUserRepository;
import com.eduit.course.hibernatejpa.db.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private CustomUserRepository custUserRepository;
	private PasswordEncoder encoder;
	
	public UserServiceImpl(UserRepository userRepository, CustomUserRepository custUserRepository, PasswordEncoder encoder) {
		this.userRepository = userRepository;
		this.custUserRepository = custUserRepository;
		this.encoder = encoder;
	}

	@Override
	public UserEntity createUser(String username, String firstName, String lastName, String email,
			String password, Date dateCreated) {
		
		UserEntity ue2 = new UserEntity();
		ue2.setUsername(username);
		ue2.setEmail(email);
		ue2.setFirstName(firstName);
		ue2.setLastName(lastName);
		ue2.setPassword(encoder.encode(password));
		ue2.setDateCreated(dateCreated);
		try {
			UserEntity newUser = userRepository.save(ue2);
			return newUser;
		} catch (Exception e) {
			throw new RuntimeException("Error", e);
		}
		
	}

	@Override
	public UserEntity login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
