package com.eduit.course.hibernatejpa.db.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eduit.course.hibernatejpa.db.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

	List<ProductEntity> findByCategory(ProductEntity parentCategory);
	
}
