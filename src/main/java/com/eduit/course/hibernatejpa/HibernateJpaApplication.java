package com.eduit.course.hibernatejpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class HibernateJpaApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
      .getLogger(HibernateJpaApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(HibernateJpaApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }
     
    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
		LOG.info("DONE");
    }
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
}
