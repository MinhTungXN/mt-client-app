package com.vu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vu.constant.ParameterConstant;
import com.vu.constant.QueryConstant;
import com.vu.dto.ProductDto;
import com.vu.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, PagingAndSortingRepository<Product, Long>{

	Product findByLink(String productLink);

	List<Product> findByStatus(String productStatus);

	@Query(nativeQuery = true,
			value = QueryConstant.FIND_PRODUCTS_BY_CATEGORY_TYPE)
	List<Product> findByCategoryType(@Param(ParameterConstant.CATEGORY_TYPE_PARAMETER) String categoryType);

	@Query(nativeQuery = true,
			value = QueryConstant.FIND_RANDOM_PRODUCTS)
	List<Product> findByRandom();

	@Query(nativeQuery = true,
			value = QueryConstant.FIND_PRODUCTS_BY_NAME_CONTAINS_KEYWORD)
	List<Product> findByNameContains(@Param(ParameterConstant.KEYWORD_PARAMETER) String keyword);

	@Query(nativeQuery = true,
			value = QueryConstant.FIND_ALL_PRODUCTS_WITH_CATEGORY_NAME)
	List<Product> findAllWithCategoryName();

	@Query(nativeQuery = true,
			value = QueryConstant.FIND_PRODUCT_BY_ID_WITH_CATEGORY_NAME)
	Product findProductByIdWithCategoryName(@Param(ParameterConstant.PRODUCT_ID_PARAMETER) Long productId);
	
	@Query(nativeQuery = true,
			value = QueryConstant.FILTER_PRICE_BY_RANGER)
	List<Product> findProductByFilterRanger(@Param(ParameterConstant.FILTER_MIN) Double min, @Param(ParameterConstant.FILTER_MAX) Double max);

	
	Page<Product> findAll(Pageable pageable);
}

