package com.eduit.course.hibernatejpa.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.eduit.course.hibernatejpa.db.entity.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

	
}
