package com.vu.dto;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.vu.constant.EntityConstant;
import com.vu.entity.Product;

public class CategoryDto {

	private Long id;
	private Long brandId;
	private String name;
	private String link;
	private String type;
	List<Product> products;
	
	public CategoryDto() {
		super();
	}

	public CategoryDto(Long brandId, String name, String link, String type) {
		super();
		this.brandId = brandId;
		this.name = name;
		this.link = link;
		this.type = type;
	}

	public CategoryDto(Long id, Long brandId, String name, String link, String type) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.name = name;
		this.link = link;
		this.type = type;
	}

	public CategoryDto(Long brandId, String name, String link, String type, List<Product> products) {
		super();
		this.brandId = brandId;
		this.name = name;
		this.link = link;
		this.type = type;
		this.products = products;
	}

	public CategoryDto(Long id, Long brandId, String name, String link, String type, List<Product> products) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.name = name;
		this.link = link;
		this.type = type;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (obj == null || getClass() != obj.getClass()) return false;
		
		CategoryDto that = (CategoryDto) obj;
		
		return new EqualsBuilder()
			.append(id, that.id)
			.append(brandId, that.brandId)
			.append(name, that.name)
			.append(link, that.link)
			.append(type, that.type)
			.append(products, that.products)
			.isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(15, 35)
			.append(id)
			.append(name)
			.append(link)
			.append(type)
			.append(brandId)
			.append(products)
			.toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append(EntityConstant.ID_COLUMN, id)
			.append(EntityConstant.BRAND_ID_COLUMN, brandId)
			.append(EntityConstant.NAME_COLUMN, name)
			.append(EntityConstant.LINK_COLUMN, link)
			.append(EntityConstant.TYPE_COLUMN, type)
			.append(EntityConstant.PRODUCTS_MAPPED_FIELD, products)
			.toString();
	}
}
