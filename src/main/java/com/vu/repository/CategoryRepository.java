package com.vu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vu.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findByType(String categoryType);
	
	List<Category> findByBrand(String categoryBrand);
	
	Category findByLink(String categoryLink);
}
