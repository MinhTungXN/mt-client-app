package com.vu.service;

import java.util.List;

import com.vu.dto.BrandDto;

public interface BrandService {
	
	  BrandDto createNewBrand(BrandDto brandDto);
	
	 void updateBrand(BrandDto brandDto);
	    
	 void deleteBrand(Long brandId);

	 List<BrandDto> getBrands();
	    
	 List<BrandDto> getBrandsByName(String brandName);
	 
	 List<BrandDto> getBrandsByCategoryType(String categoryType);
	   
	 BrandDto getBrandByLink(String brandLink);
}

