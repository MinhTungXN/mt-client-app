package com.vu.dto;

import java.util.Date;

public class ProductDto {

	private Long id;
	private Long categoryId;
	private String categoryName;
	private String name;
    private String link;
    private Float price;
    private String image;
    private String description;
    private String keyword;
    private String status;
    private Integer quantity;
    private int active;
    private Date createdAt;
    private Date modifiedAt;
    
	public ProductDto() {
		super();
	}

	public ProductDto(Long categoryId, String categoryName, String name, String link, Float price, String image, String description,
			String keyword, String status, Integer quantity, int active) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.name = name;
		this.link = link;
		this.price = price;
		this.image = image;
		this.description = description;
		this.keyword = keyword;
		this.status = status;
		this.quantity = quantity;
		this.active = active;
	}

	public ProductDto(Long id, Long categoryId, String categoryName, String name, String link, Float price, String image, String description,
			String keyword, String status, Integer quantity, int active) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.name = name;
		this.link = link;
		this.price = price;
		this.image = image;
		this.description = description;
		this.keyword = keyword;
		this.status = status;
		this.quantity = quantity;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
}
