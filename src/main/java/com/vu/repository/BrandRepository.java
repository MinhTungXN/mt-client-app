package com.vu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vu.constant.ParameterConstant;
import com.vu.constant.QueryConstant;
import com.vu.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{

	List<Brand> findByName(String name);
	
	Brand findByLink(String link);
	
	@Query(
	        nativeQuery = true,
	        value = QueryConstant.FIND_BRANDS_BY_CATEGORY_TYPE
	    )
	List<Brand> findBrandByCategoryType(@Param(ParameterConstant.CATEGORY_TYPE_PARAMETER) String CategoryType);
}
