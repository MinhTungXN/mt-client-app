package com.vu.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vu.constant.MessageConstant;
import com.vu.dto.CategoryDto;
import com.vu.entity.Category;
import com.vu.repository.CategoryRepository;
import com.vu.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	private final CategoryRepository categoryRepository;
	private final ModelMapper modelMapper;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
		this.categoryRepository = categoryRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public CategoryDto createNewCategory(CategoryDto categoryDto) {
		Category category = categoryRepository.findByLink(categoryDto.getLink());		
		if (Optional.ofNullable(category).isEmpty()) {
			category = modelMapper.map(categoryDto, Category.class);
			category.setCreatedAt(new Date());
			categoryRepository.save(category);
		}
		return categoryDto;
	}

	@Override
	public void updateCategory(CategoryDto categoryDto) {
		Category category = categoryRepository.findByLink(categoryDto.getLink());
		if (Optional.ofNullable(category).isPresent()) {
			category = modelMapper.map(categoryDto, Category.class);
			category.setModifiedAt(new Date());
			categoryRepository.save(category);
		}
	}

	@Override
	public void deleteCategory(Long categoryId) {
		Category category = categoryRepository.findById(categoryId).orElse(null);
        if (Optional.ofNullable(category).isPresent()) {
        	LOGGER.info(MessageConstant.DELETE_CATEGORY_BY_ID, categoryId);
            categoryRepository.deleteById(category.getId());
        }
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = categoryRepository.findAll();
		return categories
				.stream()
				.map(category -> modelMapper.map(category, CategoryDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<CategoryDto> getCategoriesByType(String categoryType) {
		List<Category> categories = categoryRepository.findByType(categoryType);
		return categories
				.stream()
				.map(category -> modelMapper.map(category, CategoryDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<CategoryDto> getCategoriesByBrand(String categoryBrand) {
		List<Category> categories = categoryRepository.findByBrand(categoryBrand);
		return categories
				.stream()
				.map(category -> modelMapper.map(category, CategoryDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public CategoryDto getCategoryByLink(String categoryLink) {
		Category category = categoryRepository.findByLink(categoryLink);
		return modelMapper.map(category, CategoryDto.class);
	}
}
