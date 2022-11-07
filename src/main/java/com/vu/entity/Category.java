package com.vu.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.vu.constant.EntityConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = EntityConstant.CATEGORY_TABLE, schema = EntityConstant.PUBLIC_SCHEMA,
	   uniqueConstraints = {@UniqueConstraint(name = EntityConstant.CATEGORY_UK,
				  			columnNames = EntityConstant.LINK_COLUMN)})
public class Category extends Audit {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = EntityConstant.ID_COLUMN, nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = EntityConstant.BRAND_ID_COLUMN, nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Brand brand;
	
	@NotBlank
	@Column(name = EntityConstant.NAME_COLUMN, length = 200, nullable = false)
	private String name;
	
	@NotBlank
	@Column(name = EntityConstant.LINK_COLUMN, length = 255, nullable = false)
	private String link;
	
	@NotBlank
	@Column(name = EntityConstant.TYPE_COLUMN, length = 45, nullable = false)
	private String type;
	
	@OneToMany(mappedBy = EntityConstant.CATEGORY_MAPPED_FIELD)
	List<Product> products;
	
	public Category() {
	}

	public Category(Brand brand, @NotBlank String name, @NotBlank String link, @NotBlank String type,
			List<Product> products) {
		super();
		this.brand = brand;
		this.name = name;
		this.link = link;
		this.type = type;
		this.products = products;
	}

	public Category(Long id, Brand brand, @NotBlank String name, @NotBlank String link, @NotBlank String type,
			List<Product> products) {
		super();
		this.id = id;
		this.brand = brand;
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

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
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
}
