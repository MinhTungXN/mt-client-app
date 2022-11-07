package com.vu.constant;

public class QueryConstant {

	public static final String FIND_PRODUCTS_BY_CATEGORY_TYPE = 
			"select p.id, p.category_id, p.name, p.link, p.price, p.image, " + 
				   "p.description, p.keyword, p.status, p.quantity, p.active " + 
			"from public.product p " + 
				  "inner join public.category c on p.category_id = c.id " + 
		    "where c.type = (:categoryType);";
	
	public static final String FIND_BRANDS_BY_CATEGORY_TYPE = 
			"select distinct b.id, b.name, b.link " + 
			"from public.brand b " + 
				  "inner join public.category c on c.brand_id = b.id " + 
		    "where c.type = (:categoryType);";
	
	public static final String FIND_RANDOM_PRODUCTS = 
			"select * " + 
			"from public.product p " + 
				  "order by random() limit 6;";
	
	public static final String FIND_PRODUCTS_BY_NAME_CONTAINS_KEYWORD = 
			"select * " + 
			"from public.product p " + 
		    "where p.name like (:keyword);";
	
	public static final String FIND_ROLE_NAMES_BY_USER_ID = 
			"select r.name from public.role r " + 
				   "inner join public.user u on r.id = u.role_id " +
            "where u.id = (:userId);";
	
	public static final String FIND_USER_BY_EMAIL = 
			"select * from public.user u " + 
			"where u.email = (:email);";
	
	public static final String FIND_ALL_PRODUCTS_WITH_CATEGORY_NAME = 
			"select p.id, p.category_id, c.name, p.name, p.link, p.price, p.image, " + 
				   "p.description, p.keyword, p.status, p.quantity, p.active " + 
			"from public.product p " + 
				  "inner join public.category c on p.category_id = c.id;";
	
	public static final String FIND_PRODUCT_BY_ID_WITH_CATEGORY_NAME = 
			"select p.id, p.category_id, c.name, p.name, p.link, p.price, " + 
				   "p.image, p.description, p.keyword, p.status, p.quantity, " + 
				   "p.active, p.created_at, p.modified_at " + 
			"from public.product p " + 
				  "inner join public.category c on p.category_id = c.id " + 
				  "where p.id = (:productId);";
	
	public static final String FILTER_PRICE_BY_RANGER =
			"select *" +
			"from public.product p " +
			"where p.price between (:min) and (:max);";
}
