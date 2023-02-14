package com.eduit.course.hibernatejpa;

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

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class HibernateJpaApplicationTest {

    @Autowired
    private ApplicationContext context;
    
    private UserRepository userRepository;
    private CustomUserRepository customUserRepository;
    private PasswordEncoder encoder;
	
    @BeforeEach
    public void setup() {
    	userRepository = context.getBean(UserRepository.class);
    	customUserRepository = context.getBean(CustomUserRepository.class);
		encoder = context.getBean(PasswordEncoder.class);
    }
    
    @AfterEach
    public void destroy() {
    	userRepository.deleteAll();
    }
    
	@Test
	public void testCreateUser_OK() {

		
		UserEntity ue2 = new UserEntity();
		ue2.setUsername("test4");
		ue2.setEmail("demo4@demo.com");
		ue2.setFirstName("JUAN");
		ue2.setLastName("PEREZ");
		ue2.setPassword(encoder.encode("123"));
		ue2.setDateCreated(new Date());
		customUserRepository.createUserWithSQL(ue2);
		
		Optional<UserEntity> olg = customUserRepository.login("test4", "123");
		assertTrue(olg.isPresent());
	}

}
