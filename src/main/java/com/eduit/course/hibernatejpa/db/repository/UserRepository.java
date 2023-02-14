package com.eduit.course.hibernatejpa.db.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eduit.course.hibernatejpa.db.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	

	Optional<UserEntity> findOneByEmail(String email);
	
	List<UserEntity> findTop10ByFirstName(String firstName);
	
	List<UserEntity> findAllByFirstName(String firstName, Pageable pageable);
	
	List<UserEntity> findByLastNameOrderByFirstNameAsc(String lastname);
	
	@Query(value = "SELECT u FROM UserEntity u WHERE u.email = :email AND password = CONCAT('*', UPPER(SHA1(UNHEX(SHA1(:password)))))")
	Optional<UserEntity> login(@Param("email") String email, @Param("password") String password);
	
}