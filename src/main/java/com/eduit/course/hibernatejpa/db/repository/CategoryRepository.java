package com.eduit.course.hibernatejpa.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.eduit.course.hibernatejpa.db.entity.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
	
	List<CategoryEntity> findByParent(CategoryEntity parentCategory);
	
	Optional<CategoryEntity> findOneByName(String name);
}
