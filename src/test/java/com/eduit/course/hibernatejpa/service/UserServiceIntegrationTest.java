package com.eduit.course.hibernatejpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.eduit.course.hibernatejpa.db.entity.UserEntity;
import com.eduit.course.hibernatejpa.db.repository.CustomUserRepository;
import com.eduit.course.hibernatejpa.db.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class UserServiceIntegrationTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Autowired
    private ApplicationContext context;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

    
    private UserRepository userRepository;
    private CustomUserRepository customUserRepository;
    private PasswordEncoder encoder;
    private UserService userService;
    
	
    @BeforeEach
    public void setup() {
    	userRepository = context.getBean(UserRepository.class);
    	customUserRepository = context.getBean(CustomUserRepository.class);
		encoder = context.getBean(PasswordEncoder.class);
		userService = context.getBean(UserService.class);
    }
    
    @AfterEach
    public void destroy() {
    	JdbcTestUtils.deleteFromTables(jdbcTemplate, UserEntity.TABLE_NAME);
    }
   
    
	@Test
	public void testCreateUser_OK() {
		String username = "test4";
		String firstName = "JUAN"; 
		String lastName = "PEREZ";
		String email = "demo4@demo.com";
		String password = "123"; 
		Date dateCreated = new Date();
		
		UserEntity response = userService.createUser(username, firstName, lastName, email, password, dateCreated);
		
		assertNotNull(response);
		assertEquals(response.getUsername(), username);
	}
	
	@Test
	public void testCreateUser_DuplicatedError() {
		String username = "test5";
		String firstName = "JUAN"; 
		String lastName = "PEREZ";
		String email = "demo5@demo.com";
		String password = "123"; 
		Date dateCreated = new Date();
		
		UserEntity response = userService.createUser(username, firstName, lastName, email, password, dateCreated);
		
		assertNotNull(response);
		assertEquals(response.getUsername(), username);

		try {
			userService.createUser(username, firstName, lastName, email, password, dateCreated);
		} catch (Exception e) {
			assertEquals(e.getClass(), RuntimeException.class);
			assertEquals(e.getMessage(), "Error");
		}
		
	}

}
