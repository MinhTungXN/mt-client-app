package com.vu.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vu.constant.MessageConstant;
import com.vu.dto.BrandDto;
import com.vu.entity.Brand;
import com.vu.repository.BrandRepository;
import com.vu.service.BrandService;

@Service
@Transactional
public class BrandServiceImpl implements BrandService{

	private static final Logger LOGGER = LoggerFactory.getLogger(BrandServiceImpl.class);

	private final BrandRepository brandRepository;
	private final ModelMapper modelMapper;
	
	public BrandServiceImpl (BrandRepository brandRepository, ModelMapper modelMapper) {
		this.brandRepository = brandRepository;
		this.modelMapper = modelMapper;
	}
	
	
	@Override
	public BrandDto createNewBrand(BrandDto brandDto) {
		Brand brand = brandRepository.findByLink(brandDto.getLink());
		if(Optional.ofNullable(brand).isEmpty()) {
			brand = modelMapper.map(brandDto, Brand.class);
			brandRepository.save(brand);
		}
		return brandDto;
	}

	@Override
	public void updateBrand(BrandDto brandDto) {
		Brand brand = brandRepository.findByLink(brandDto.getLink());
		if(Optional.ofNullable(brand).isPresent()) {
			brand = modelMapper.map(brandDto, Brand.class);
			brandRepository.save(brand);
		}
	}

	@Override
	public void deleteBrand(Long brandId) {
		Brand brand = brandRepository.findById(brandId).orElse(null);
		if(Optional.ofNullable(brand).isPresent()) {
			LOGGER.info(MessageConstant.DELETE_BRAND_BY_ID, brandId);
			brandRepository.deleteById(brand.getId());
		}
	}

	@Override
	public List<BrandDto> getBrands() {
		List<Brand> brands = brandRepository.findAll();
		return brands
				.stream()
				.map(brand -> modelMapper.map(brands, BrandDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<BrandDto> getBrandsByName(String brandName) {
		List<Brand> brands = brandRepository.findByName(brandName);
		return brands
				.stream()
				.map(brand -> modelMapper.map(brands, BrandDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public BrandDto getBrandByLink(String brandLink) {
		Brand brand = brandRepository.findByLink(brandLink);
		return modelMapper.map(brand, BrandDto.class);
	}

	@Override
	public List<BrandDto> getBrandsByCategoryType(String categoryType) {
		List<Brand> brands = brandRepository.findBrandByCategoryType(categoryType);
		return brands
				.stream()
				.map(brand -> modelMapper.map(brand, BrandDto.class))
				.collect(Collectors.toList());
	}
	
}
