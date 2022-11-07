package com.vu.service;

import java.util.List;

import com.vu.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto createNewCategory(CategoryDto categoryDto);
	
	void updateCategory(CategoryDto categoryDto);
	
	void deleteCategory(Long categoryId);

	List<CategoryDto> getCategories();
	
	List<CategoryDto> getCategoriesByType(String categoryType);
	
	List<CategoryDto> getCategoriesByBrand(String categoryBrand);
	
	CategoryDto getCategoryByLink(String categoryLink);
}
