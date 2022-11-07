package com.vu.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import com.vu.constant.EntityConstant;

@Entity
@Table(name = EntityConstant.BRAND_TABLE, schema = EntityConstant.PUBLIC_SCHEMA,
	   uniqueConstraints = {@UniqueConstraint(name = EntityConstant.BRAND_UK,
				  			columnNames = EntityConstant.LINK_COLUMN)})
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = EntityConstant.ID_COLUMN, nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name = EntityConstant.NAME_COLUMN, length = 200, nullable = false)
	private String name;
	
	@NotBlank
	@Column(name = EntityConstant.LINK_COLUMN, length = 255, nullable = false)
	private String link;
	
	@OneToMany(mappedBy = EntityConstant.BRAND_MAPPED_FIELD)
	List<Category> categories;

	public Brand() {
		super();
	}

	public Brand(@NotBlank String name, @NotBlank String link, List<Category> categories) {
		super();
		this.name = name;
		this.link = link;
		this.categories = categories;
	}

	public Brand(Long id, @NotBlank String name, @NotBlank String link, List<Category> categories) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.categories = categories;
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
