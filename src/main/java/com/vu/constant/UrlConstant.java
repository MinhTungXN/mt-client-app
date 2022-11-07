package com.vu.constant;

public class UrlConstant {

	// -- B2C Home URLs
    public static final String B2C_DEFAULT_URL = "/b2c";
    public static final String B2C_SHORT_URL = "/";
    public static final String B2C_HOME_URL = "/home";
    public static final String B2C_ABOUT_URL = "/about";
    public static final String B2C_CONTACT_URL = "/contact";
    public static final String B2C_SHOP_URL = "/shop";
    public static final String B2C_SEARCH_URL = "/search";
    
    // -- B2C Product URLs
    public static final String B2C_BEST_SELLER_PRODUCTS_URL = "/best-sellers";
    public static final String B2C_NEW_ARRIVAL_PRODUCTS_URL = "/new-arrivals";
    public static final String B2C_HOT_SALE_PRODUCTS_URL = "/hot-sales";
    public static final String B2C_FILTER_BY_RANGER_URL = "/filter";
    
    // -- B2C Category URLs
    public static final String B2C_CATEGORIES_URL = "/categories";
    public static final String B2C_CLOTHING_CATEGORIES_URL = "/clothing";
    public static final String B2C_SHOE_CATEGORIES_URL = "/shoes";
    public static final String B2C_ACCESSORY_CATEGORIES_URL = "/accessories";
    
    // -- B2C Shared Data URLs
    public static final String B2C_SHARED_DATA_URL = "/*";
    
    // -- Admin Home URLs
    public static final String ADMIN_DEFAULT_URL = "/admin";
    public static final String ADMIN_HOME_URL = "/admin/home";
    
    // -- Admin Shared Data URLs
    public static final String ADMIN_AUTH_URL = "/admin/*";
    
    // -- Admin Product URLs
    public static final String ADMIN_ALL_PRODUCTS_URL = "/admin/products";
    public static final String ADMIN_PRODUCT_DETAILS_URL = "/admin/product/details";
    public static final String ADMIN_PRODUCT_ADD_URL = "/admin/product/add";
    public static final String ADMIN_PRODUCT_EDIT_URL = "/admin/product/edit/{id}";
    public static final String ADMIN_PRODUCT_REMOVE_URL = "/admin/product/remove/{id}";
    
    // -- Common Resource URLs
    public static final String CSS_FILES_PATH_URL = "/css/**";
    public static final String JS_FILES_PATH_URL = "/js/**";
    public static final String B2C_FILES_PATH_URL = "/b2c/**";
    public static final String ADMIN_FILE_PATH_URL = "/admin/**";
    public static final String USER_FILE_PATH_URL = "/user/**";
    
    // -- B2C User URLs
    public static final String B2C_USER_PROFILE_URL = "/profile";
    
    // -- Security Check URLs
    public static final String B2C_LOGIN_URL = "/login";
    public static final String B2C_LOGOUT_URL = "/logout";
    public static final String SECURITY_CHECK_URL = "/j_spring_security_check";
    public static final String LOGIN_FAILURE_URL = "/login?error=true";
    public static final String LOGOUT_SUCCESS_URL = "/login?logout=true";
    public static final String REDIRECT_LOGIN_URL = "redirect:/login";
    
    // -- B2C Error URLs
    public static final String B2C_ACCESS_DENIED_URL = "/access-denied";
    public static final String B2C_NOT_FOUND_URL = "/not-found";
    
    // -- Auth API URLs
    public static final String B2C_AUTH_API_URL = "/api/auth";
    public static final String B2C_LOGIN_API_URL = "/login";
    
    // -- B2C Category API URLs
    public static final String B2C_CATEGORY_API_URL = "/api/category";
    public static final String B2C_CATEGORY_LIST_API_URL = "/list";
    public static final String B2C_CLOTHING_CATEGORY_API_URL = "/clothings";
    public static final String B2C_SHOE_CATEGORY_API_URL = "/shoes";
    public static final String B2C_ACCESSORY_CATEGORY_API_URL = "/accessories";
    
    // -- B2C Product API URLs
    public static final String PRODUCT_API_URL = "/api/product";
    public static final String B2C_NEW_ARRIVAL_PRODUCTS_API_URL = "/new-arrivals";
    public static final String B2C_HOT_SALE_PRODUCTS_API_URL = "/hot-sales";
    public static final String B2C_BEST_SELLER_PRODUCTS_API_URL = "best-sellers";
    
    public static final String ADMIN_PRODUCT_LIST_API_URL = "/list";
    public static final String ADMIN_PRODUCT_DETAILS_API_URL = "/details";
    public static final String ADMIN_PRODUCT_ADD_API_URL = "/add";
    public static final String ADMIN_PRODUCT_EDIT_API_URL = "/edit/{id}";
    public static final String ADMIN_PRODUCT_REMOVE_API_URL = "/remove/{id}";
}
