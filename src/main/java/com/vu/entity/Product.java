package com.vu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.vu.constant.EntityConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = EntityConstant.PRODUCT_TABLE, schema = EntityConstant.PUBLIC_SCHEMA,
		uniqueConstraints = {@UniqueConstraint(name = EntityConstant.PRODUCT_UK,
								columnNames = EntityConstant.LINK_COLUMN)})
												
public class Product extends Audit {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = EntityConstant.ID_COLUMN, nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = EntityConstant.CATEGORY_ID_COLUMN, nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Category category;
	
	@Column(name = EntityConstant.NAME_COLUMN, length = 200, nullable = false)
	private String name;
	
    @Column(name = EntityConstant.LINK_COLUMN, length = 255, nullable = false)
    private String link;
	
    @Column(name = EntityConstant.PRICE_COLUMN, nullable = false)
    private Float price;

    @Column(name = EntityConstant.IMAGE_COLUMN, length = 255, nullable = false)
    private String image;
    
    @Column(name = EntityConstant.DESCRIPTION_COLUMN, 
    		columnDefinition = EntityConstant.TEXT_COLUMN_DEFINITION, 
    		nullable = false)
    private String description;
    
    @Column(name = EntityConstant.KEYWORD_COLUMN, length = 200, nullable = false)
    private String keyword;

    @Column(name = EntityConstant.STATUS_COLUMN, length = 50, nullable = false)
    private String status;

    @Column(name = EntityConstant.QUANTITY_COLUMN, nullable = false)
    private Integer quantity;

    @Column(name = EntityConstant.ACTIVE_COLUMN, nullable = false)
    private int active;
    
    public Product() {
    }
    
	public Product(Category category, String name, String link, Float price, String image, 
					String description, String keyword, String status, Integer quantity, int active) {
		super();
		this.category = category;
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

	public Product(Long id, Category category, String name, String link, Float price, String image, 
					String description, String keyword, String status, Integer quantity, int active) {
		super();
		this.id = id;
		this.category = category;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
}
