package com.vu.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.vu.constant.MessageConstant;
import com.vu.constant.ParameterConstant;
import com.vu.dto.ProductDto;
import com.vu.entity.Category;
import com.vu.entity.Product;
import com.vu.repository.CategoryRepository;
import com.vu.repository.ProductRepository;
import com.vu.service.ProductService;

import ch.qos.logback.core.joran.conditional.ElseAction;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;

	public ProductServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository,
			ModelMapper modelMapper) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProductDto createNewProduct(ProductDto productDto) {
		Product product = productRepository.findByLink(productDto.getLink());
		if (Optional.ofNullable(product).isEmpty()) {
			product = modelMapper.map(productDto, Product.class);
			product.setCreatedAt(new Date());
			productRepository.save(product);
		}

		ProductDto newProduct = modelMapper.map(product, ProductDto.class);

		Category category = categoryRepository.findById(product.getCategory().getId()).get();
		newProduct.setCategoryName(category.getName());

		return newProduct;
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto) {
		Product product = productRepository.findById(productDto.getId()).orElse(null);
		if (Optional.ofNullable(product).isPresent()) {
			product = modelMapper.map(productDto, Product.class);
			product.setModifiedAt(new Date());
			productRepository.save(product);
		}

		ProductDto existingProduct = modelMapper.map(product, ProductDto.class);

		Category category = categoryRepository.findById(product.getCategory().getId()).get();
		existingProduct.setCategoryName(category.getName());

		return existingProduct;
	}

	@Override
	public void deleteProduct(Long productId) {
		Product product = productRepository.findById(productId).orElse(null);
		if (Optional.ofNullable(product).isPresent()) {
			LOGGER.info(MessageConstant.DELETE_PRODUCT_BY_ID, productId);
			productRepository.deleteById(product.getId());
		}
	}

	@Override
	public List<ProductDto> getProducts(Pageable pageable) {
		Page<Product> products = productRepository.findAll(pageable);
		return products.stream().map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getProductsByStatus(String productStatus) {
		List<Product> products = productRepository.findByStatus(productStatus);
		return products.stream().map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProductDto getProductByLink(String productLink) {
		Product product = productRepository.findByLink(productLink);
		return modelMapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getProductsByCategoryType(String categoryType) {
		List<Product> products = productRepository.findByCategoryType(categoryType);
		return products.stream().map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getRandomProducts() {
		List<Product> products = productRepository.findByRandom();
		return products.stream().map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getProductsByKeyword(Optional<String> keyword) {
		List<Product> products;

		if (keyword.isPresent()) {
			String formattedKeyword = "%" + keyword.get() + "%";
			products = productRepository.findByNameContains(formattedKeyword);
		} else {
			products = productRepository.findByRandom();
		}

		return products.stream().map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getProductsWithCategoryName() {
		List<Product> products = productRepository.findAllWithCategoryName();
		return products.stream().map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProductDto getProductByIdWithCategoryName(Long productId) {
		Product entity = productRepository.findProductByIdWithCategoryName(productId);
		return modelMapper.map(entity, ProductDto.class);
	}

	@Override
	public ProductDto getProductById(Long productId) {
		Product entity = productRepository.findById(productId).orElse(null);
		if (Optional.ofNullable(entity).isPresent()) {
			return modelMapper.map(entity, ProductDto.class);
		}
		return null;
	}

	@Override
	public List<ProductDto> getProductByFilterRanger(Double min, Double max) {
		List<Product> listProducts = productRepository.findProductByFilterRanger(min, max);
		return listProducts.stream().map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public int getTotalPage() {
		return productRepository.findAll(PageRequest.of(0, ParameterConstant.PRODUCTS_ON_ONE_PAGE)).getTotalPages();
	}
}
