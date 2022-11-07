package com.vu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vu.dto.ProductDto;
import com.vu.entity.Product;

public interface ProductService{

	   	ProductDto createNewProduct(ProductDto productDto);

	    ProductDto updateProduct(ProductDto productDto);

	    void deleteProduct(Long productId);

	    List<ProductDto> getRandomProducts();

	    List<ProductDto> getProductsByKeyword(Optional<String> keyword);

	    List<ProductDto> getProductsByStatus(String productStatus);

	    List<ProductDto> getProductsByCategoryType(String categoryType);

	    ProductDto getProductByLink(String productLink);

	    List<ProductDto> getProductsWithCategoryName();

	    ProductDto getProductByIdWithCategoryName(Long productId);

	    ProductDto getProductById(Long productId);
	    
	    List<ProductDto> getProductByFilterRanger(Double min, Double max);
	    
	    List<ProductDto> getProducts(Pageable pageable);
	    
	    int getTotalPage();
	    
	}

