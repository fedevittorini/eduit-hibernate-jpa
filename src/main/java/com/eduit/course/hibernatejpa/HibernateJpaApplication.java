package com.eduit.course.hibernatejpa;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.eduit.course.hibernatejpa.db.entity.UserEntity;
import com.eduit.course.hibernatejpa.db.repository.CustomUserRepository;
import com.eduit.course.hibernatejpa.db.repository.UserRepository;

@SpringBootApplication
public class HibernateJpaApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
      .getLogger(HibernateJpaApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(HibernateJpaApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }
 
    @Autowired
    private ApplicationContext context;
    
    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
		UserRepository ur = context.getBean(UserRepository.class);
		CustomUserRepository cur = context.getBean(CustomUserRepository.class);
		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
		
//		UserEntity ue2 = new UserEntity();
//		ue2.setUsername("test4");
//		ue2.setEmail("demo4@demo.com");
//		ue2.setFirstName("JUAN");
//		ue2.setLastName("PEREZ");
//		ue2.setPassword(encoder.encode("123"));
//		ue2.setDateCreated(new Date());
//		cur.createUserWithSQL(ue2);
//		
//		Optional<UserEntity> olg = cur.login("test4", "123");
		LOG.info("DONE");
    }
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
}
