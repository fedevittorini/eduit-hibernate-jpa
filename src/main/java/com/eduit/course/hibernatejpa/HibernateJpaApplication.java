package com.eduit.course.hibernatejpa;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.eduit.course.hibernatejpa.db.entity.CategoryEntity;
import com.eduit.course.hibernatejpa.db.repository.CategoryRepository;

@SpringBootApplication
public class HibernateJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext apc = SpringApplication.run(HibernateJpaApplication.class, args);
		CategoryRepository cr = apc.getBean(CategoryRepository.class);
		CategoryEntity c = new CategoryEntity();
		c.setName("DEMO");
		c.setDateCreated(new Date());
		cr.save(c);
	}

}
