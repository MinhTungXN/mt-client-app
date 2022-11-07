package com.vu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.vu.constant.AttributeConstant;
import com.vu.constant.UrlConstant;
import com.vu.constant.ViewConstant;
import com.vu.constant.FormConstant;
import com.vu.constant.ParameterConstant;
import com.vu.dto.BrandDto;
import com.vu.dto.CategoryDto;
import com.vu.dto.ProductDto;
import com.vu.entity.ProductStatus;
import com.vu.form.SearchForm;
import com.vu.service.BrandService;
import com.vu.service.CategoryService;
import com.vu.service.ProductService;

@Controller
public class MainController {

	private final BrandService brandService;
	private final CategoryService categoryService;
	private final ProductService productService;

	public MainController(BrandService brandService, CategoryService categoryService, ProductService productService) {
		this.brandService = brandService;
		this.categoryService = categoryService;
		this.productService = productService;
	}

	@GetMapping(value = { UrlConstant.B2C_HOME_URL, UrlConstant.B2C_SHORT_URL })
	public String getHome(Model model, @ModelAttribute(FormConstant.B2C_SEARCH_FORM) Optional<SearchForm> searchForm) {
		List<ProductDto> newProducts = productService.getProductsByStatus(ProductStatus.NEW.toString());
		List<ProductDto> bestSellersProducts = productService
				.getProductsByStatus(ProductStatus.BEST_SELLERS.toString());
		List<ProductDto> hotSalesProduct = productService
				.getProductsByStatus(ProductStatus.HOT_SALES_PRODUCT.toString());

		model.addAttribute(AttributeConstant.B2C_NEW_PRODUCTS_ATTRIBUTE, newProducts);
		model.addAttribute(AttributeConstant.B2C_BEST_PRODUCTS_ATTRIBUTE, bestSellersProducts);
		model.addAttribute(AttributeConstant.B2C_HOT_SALES_PRODUCTS_ATTRIBUTE, hotSalesProduct);

		return ViewConstant.B2C_HOME_VIEW;
	}

	@GetMapping(value = { UrlConstant.B2C_ABOUT_URL })
	public String getB2CAboutView(Model model,
			@ModelAttribute(FormConstant.B2C_SEARCH_FORM) Optional<SearchForm> searchForm) {
		return ViewConstant.B2C_ABOUT_VIEW;
	}

	@GetMapping(value = { UrlConstant.B2C_CONTACT_URL })
	public String getB2CContactView(Model model,
			@ModelAttribute(FormConstant.B2C_SEARCH_FORM) Optional<SearchForm> searchForm) {
		return ViewConstant.B2C_CONTACT_VIEW;
	}

	@GetMapping(value = { UrlConstant.B2C_SHOP_URL })
	public String getB2CShopView(Model model,
//			@RequestParam("order-by") String orderBy, 
			@RequestParam("page") int curentPage,
			@ModelAttribute(FormConstant.B2C_SEARCH_FORM) Optional<SearchForm> searchForm) {

		Pageable paging = PageRequest.of(curentPage, ParameterConstant.PRODUCTS_ON_ONE_PAGE, 
				Sort.by("createdAt").descending());

//		switch (orderBy) {
//		case "random":
//			paging = PageRequest.of(page, ParameterConstant.PRODUCTS_ON_ONE_PAGE, 
//					Sort.by("createdAt").descending());
//			break;
//		case "descending":
//			paging = PageRequest.of(page, ParameterConstant.PRODUCTS_ON_ONE_PAGE, 
//					Sort.by("price").descending());
//			break;
//		case "ascending":
//			paging = PageRequest.of(page, ParameterConstant.PRODUCTS_ON_ONE_PAGE, 
//					Sort.by("price").ascending());
//			break;
//		}

		List<BrandDto> brands = brandService.getBrands();
		List<CategoryDto> categories = categoryService.getCategories();
		List<ProductDto> products = productService.getProducts(paging);
		int totalPages = productService.getTotalPage();

		model.addAttribute(AttributeConstant.B2C_BRANDS_ATTRIBUTE, brands);
		model.addAttribute(AttributeConstant.B2C_ALL_CATEGORIES_ATTRIBUTE, categories);
		model.addAttribute(AttributeConstant.B2C_PRODUCTS_ATTRIBUTE, products);
		model.addAttribute(AttributeConstant.B2C_TOTAL_PAGES_ATTRIBUTE, totalPages);
		model.addAttribute(AttributeConstant.B2C_CURRENT_PAGES_ATTRIBUTE, curentPage);

		return ViewConstant.B2C_PRODUCTS_VIEW;
	}

	@GetMapping(value = { UrlConstant.B2C_SEARCH_URL })
	public String getB2CSearchedProductsView(Model model,
			@ModelAttribute(FormConstant.B2C_SEARCH_FORM) Optional<SearchForm> searchForm) {
		List<BrandDto> brands = brandService.getBrands();
		List<CategoryDto> categories = categoryService.getCategories();

		Optional<String> keyword = Optional.ofNullable(searchForm.get().getKeyword());
		List<ProductDto> searchedProducts = productService.getProductsByKeyword(keyword);

		model.addAttribute(AttributeConstant.B2C_SEARCHED_PRODUCTS_ATTRIBUTE, searchedProducts);
		model.addAttribute(AttributeConstant.B2C_BRANDS_ATTRIBUTE, brands);
		model.addAttribute(AttributeConstant.B2C_ALL_CATEGORIES_ATTRIBUTE, categories);
		model.addAttribute(AttributeConstant.B2C_SEARCHED_PRODUCTS_ATTRIBUTE, searchedProducts);

		return ViewConstant.B2C_SEARCHED_PRODUCTS_VIEW;
	}

}
