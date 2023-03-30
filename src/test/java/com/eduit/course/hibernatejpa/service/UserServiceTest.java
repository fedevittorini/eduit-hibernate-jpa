package com.eduit.course.hibernatejpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.eduit.course.hibernatejpa.db.entity.UserEntity;
import com.eduit.course.hibernatejpa.db.repository.CustomUserRepository;
import com.eduit.course.hibernatejpa.db.repository.UserRepository;

@RunWith(JUnit4.class)
public class UserServiceTest {

	
	private UserService userService;
	
	private UserRepository userRepository;
	private CustomUserRepository custUserRepository;
	private PasswordEncoder encoder;
	
	@BeforeEach
	public void setup() {
		userRepository = mock(UserRepository.class);
		custUserRepository = mock(CustomUserRepository.class);
		encoder = mock(PasswordEncoder.class);
		userService = new UserServiceImpl(userRepository, custUserRepository, encoder);
	}
	
	@Test
	public void testCreateUser_OK() {
		String username = "test4";
		String firstName = "JUAN"; 
		String lastName = "PEREZ";
		String email = "demo4@demo.com";
		String password = "123"; 
		Date dateCreated = new Date();
		
		UserEntity ue2 = new UserEntity();
		ue2.setUsername(username);
		ue2.setEmail(email);
		ue2.setFirstName(firstName);
		ue2.setLastName(lastName);
		ue2.setPassword(password);
		ue2.setDateCreated(dateCreated);
		when(custUserRepository.createUserWithSQL(any(UserEntity.class))).thenReturn(Optional.of(ue2));
		
		
		UserEntity response = userService.createUser(username, firstName, lastName, email, password, dateCreated);
		assertNotNull(response);
		assertEquals(response.getUsername(), username);
		
	}
	

}
