package com.vu.dto;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.vu.constant.EntityConstant;
import com.vu.entity.Category;

public class BrandDto {

	private Long id;
	private String name;
	private String link;
	List<Category> categories;
	
	public BrandDto(String name, String link) {
		super();
		this.name = name;
		this.link = link;
	}
	
	public BrandDto(Long id, String name, String link) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
	}

	public BrandDto(String name, String link, List<Category> categories) {
		super();
		this.name = name;
		this.link = link;
		this.categories = categories;
	}

	public BrandDto(Long id, String name, String link, List<Category> categories) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.categories = categories;
	}

	public BrandDto() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (obj == null || getClass() != obj.getClass()) return false;
		
		BrandDto that = (BrandDto) obj;
		
		return new EqualsBuilder()
			.append(id, that.id)
			.append(name, that.name)
			.append(link, that.link)
			.append(categories, that.categories)
			.isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(15, 35)
			.append(id)
			.append(name)
			.append(link)
			.append(categories)
			.toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append(EntityConstant.ID_COLUMN, id)
			.append(EntityConstant.NAME_COLUMN, name)
			.append(EntityConstant.LINK_COLUMN, link)
			.append(EntityConstant.CATEGORIES_MAPPED_FIELD, categories)
			.toString();
	}
}
