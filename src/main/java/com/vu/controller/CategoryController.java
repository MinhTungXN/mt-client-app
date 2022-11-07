package com.vu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.vu.constant.AttributeConstant;
import com.vu.constant.FormConstant;
import com.vu.constant.ParameterConstant;
import com.vu.constant.UrlConstant;
import com.vu.constant.ViewConstant;
import com.vu.dto.BrandDto;
import com.vu.dto.CategoryDto;
import com.vu.dto.ProductDto;
import com.vu.form.SearchForm;
import com.vu.entity.CategoryType;
import com.vu.service.BrandService;
import com.vu.service.CategoryService;
import com.vu.service.ProductService;

@Controller
public class CategoryController {

	private final BrandService brandService;
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoryController(BrandService brandService, 
							CategoryService categoryService, 
							ProductService productService) {		
		this.brandService = brandService;
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@GetMapping(value = {UrlConstant.B2C_CLOTHING_CATEGORIES_URL})
	public String getB2CClothingCategoriesView(Model model, 
			@ModelAttribute(FormConstant.B2C_SEARCH_FORM) Optional<SearchForm> searchForm) {
		List<BrandDto> clothingBrands = brandService.getBrandsByCategoryType(CategoryType.CLOTHING.toString());
		List<CategoryDto> clothingCategories = categoryService.getCategoriesByType(CategoryType.CLOTHING.toString());
		List<ProductDto> clothingProducts = productService.getProductsByCategoryType(CategoryType.CLOTHING.toString());
		
		model.addAttribute(AttributeConstant.B2C_CLOTHING_BRANDS_ATTRIBUTE, clothingBrands);
		model.addAttribute(AttributeConstant.B2C_CLOTHING_CATEGORIES_ATTRIBUTE, clothingCategories);
		model.addAttribute(AttributeConstant.B2C_CLOTHING_PRODUCTS_ATTRIBUTE, clothingProducts);
		return ViewConstant.B2C_CLOTHING_CATEGORIES_VIEW;
	}
	
	@GetMapping(value = {UrlConstant.B2C_SHOE_CATEGORIES_URL})
	public String getB2CShoeCategoriesView(Model model, 
			@ModelAttribute(FormConstant.B2C_SEARCH_FORM) Optional<SearchForm> searchForm) {		
		List<BrandDto> shoeBrands = brandService.getBrandsByCategoryType(CategoryType.SHOES.toString());
		List<CategoryDto> shoeCategories = categoryService.getCategoriesByType(CategoryType.SHOES.toString());
		List<ProductDto> shoeProducts = productService.getProductsByCategoryType(CategoryType.SHOES.toString());
		
		model.addAttribute(AttributeConstant.B2C_SHOE_BRANDS_ATTRIBUTE, shoeBrands);
		model.addAttribute(AttributeConstant.B2C_SHOE_CATEGORIES_ATTRIBUTE, shoeCategories);
		model.addAttribute(AttributeConstant.B2C_SHOE_PRODUCTS_ATTRIBUTE, shoeProducts);
		return ViewConstant.B2C_SHOE_CATEGORIES_VIEW;
	}
	
	@GetMapping(value = {UrlConstant.B2C_ACCESSORY_CATEGORIES_URL})
	public String getB2CAccessoryCategoriesView(Model model, 
			@ModelAttribute(FormConstant.B2C_SEARCH_FORM) Optional<SearchForm> searchForm) {
		List<BrandDto> accessoryBrands = brandService.getBrandsByCategoryType(CategoryType.ACCESSORIES.toString());
		List<CategoryDto> accessoryCategories = categoryService.getCategoriesByType(CategoryType.ACCESSORIES.toString());
		List<ProductDto> accessoryProducts = productService.getProductsByCategoryType(CategoryType.ACCESSORIES.toString());
		
		model.addAttribute(AttributeConstant.B2C_ACCESSORY_BRANDS_ATTRIBUTE, accessoryBrands);
		model.addAttribute(AttributeConstant.B2C_ACCESSORY_CATEGORIES_ATTRIBUTE, accessoryCategories);
		model.addAttribute(AttributeConstant.B2C_ACCESSORY_PRODUCTS_ATTRIBUTE, accessoryProducts);
		return ViewConstant.B2C_ACCESSORY_CATEGORIES_VIEW;
	}
	
	@GetMapping(value = { UrlConstant.B2C_CATEGORIES_URL })
	public String getB2CShopView(Model model, 
			@RequestParam("page") int curentPage,
			@ModelAttribute(FormConstant.B2C_SEARCH_FORM) Optional<SearchForm> searchForm) {

		Pageable paging = PageRequest.of(curentPage, ParameterConstant.PRODUCTS_ON_ONE_PAGE, 
				Sort.by("createdAt").descending());

		List<BrandDto> brands = brandService.getBrands();
		List<CategoryDto> categories = categoryService.getCategories();
		List<ProductDto> products = productService.getProducts(paging);
		int totalPages = productService.getTotalPage();

		model.addAttribute(AttributeConstant.B2C_BRANDS_ATTRIBUTE, brands);
		model.addAttribute(AttributeConstant.B2C_ALL_CATEGORIES_ATTRIBUTE, categories);
		model.addAttribute(AttributeConstant.B2C_PRODUCTS_ATTRIBUTE, products);
		model.addAttribute(AttributeConstant.B2C_CURRENT_PAGES_ATTRIBUTE, curentPage);
		model.addAttribute(AttributeConstant.B2C_TOTAL_PAGES_ATTRIBUTE, totalPages);

		return ViewConstant.B2C_CATEGORIES_VIEW;
	}
}
