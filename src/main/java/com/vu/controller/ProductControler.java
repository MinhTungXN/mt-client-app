package com.vu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.vu.constant.AttributeConstant;
import com.vu.constant.FormConstant;
import com.vu.constant.UrlConstant;
import com.vu.constant.ViewConstant;
import com.vu.dto.ProductDto;
import com.vu.entity.ProductStatus;
import com.vu.form.SearchForm;
import com.vu.service.ProductService;

@Controller
public class ProductControler {

	 private final ProductService productService;
	 
	 public ProductControler(ProductService productService) {
		 this.productService = productService;
	 }
	 
	 @GetMapping(value = {UrlConstant.B2C_BEST_SELLER_PRODUCTS_URL})
	 public String getB2CProductByBestSellersStatus(Model model, 
			 @ModelAttribute(FormConstant.B2C_SEARCH_FORM) Optional<SearchForm> searchForm) {
		 List<ProductDto> bestSellers = productService.getProductsByStatus(ProductStatus.BEST_SELLERS.toString());
		 
		 model.addAttribute(AttributeConstant.B2C_BEST_PRODUCTS_ATTRIBUTE, bestSellers);
		 
		 return ViewConstant.B2C_BEST_SELLER_PRODUCTS_VIEW;
	 }
	 
	 @GetMapping(value = {UrlConstant.B2C_NEW_ARRIVAL_PRODUCTS_URL})
	 public String getB2CProductByNewArrivalsStatus(Model model, 
			 @ModelAttribute(FormConstant.B2C_SEARCH_FORM) Optional<SearchForm> searchForm) {
		 List<ProductDto> newArrivals = productService.getProductsByStatus(ProductStatus.NEW.toString());
		 
		 model.addAttribute(AttributeConstant.B2C_NEW_PRODUCTS_ATTRIBUTE, newArrivals);
		 
		 return ViewConstant.B2C_NEW_ARRIVAL_PRODUCTS_VIEW;
	 }
	 
	 @GetMapping(value = {UrlConstant.B2C_HOT_SALE_PRODUCTS_URL})
	 public String getB2CProductByHotSalesProduct(Model model, 
			 @ModelAttribute(FormConstant.B2C_SEARCH_FORM) Optional<SearchForm> searchForm) {
		 List<ProductDto> hotSaleProduct = productService.getProductsByStatus(ProductStatus.HOT_SALES_PRODUCT.toString());
		 
		 model.addAttribute(AttributeConstant.B2C_HOT_SALES_PRODUCTS_ATTRIBUTE, hotSaleProduct);
		 
		 return ViewConstant.B2C_HOT_SALE_PRODUCTS_VIEW;
	 }
	        
	 @GetMapping(value = {UrlConstant.B2C_FILTER_BY_RANGER_URL})
	 public String getB2CProductByFilterRangerView(Model model,
			 @RequestParam("min") Double min,
			 @RequestParam("max") Double max,
			 @ModelAttribute(FormConstant.B2C_SEARCH_FORM) Optional<SearchForm> searchForm) {
		 
			List<ProductDto> filterProducts = productService.getProductByFilterRanger(min, max);
			
			model.addAttribute(AttributeConstant.B2C_FILTER_PRODUCTS_BY_PRICE_ATTRIBUTE, filterProducts);			
	
		 return ViewConstant.B2C_FILTER_PRODUCTS_VIEW;
	 }
	
}

