package com.eduit.course.hibernatejpa.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.eduit.course.hibernatejpa.db.entity.CartEntity;

public interface CartRepository extends CrudRepository<CartEntity, Long> {

	
}
