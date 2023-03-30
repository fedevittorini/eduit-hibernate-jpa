package com.eduit.course.hibernatejpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.eduit.course.hibernatejpa.db.entity.UserEntity;
import com.eduit.course.hibernatejpa.db.repository.CustomUserRepository;
import com.eduit.course.hibernatejpa.db.repository.UserRepository;
import com.eduit.course.hibernatejpa.service.UserService;
import com.eduit.course.hibernatejpa.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class HibernateJpaApplicationTest {

    @Autowired
    private ApplicationContext context;
    
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
    	userRepository.deleteAll();
    }
    
    
    @Test
	public void testContext() {
    	assertNotNull(userRepository);
    	assertNotNull(customUserRepository);
    	assertNotNull(encoder);
    	assertNotNull(userService);
    }

}
