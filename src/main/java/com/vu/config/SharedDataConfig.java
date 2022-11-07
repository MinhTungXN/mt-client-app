package com.vu.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vu.constant.UrlConstant;
import com.vu.filter.SharedDataFilter;
import com.vu.service.CategoryService;

@Configuration
public class SharedDataConfig {

	private final CategoryService categoryService;
	
	public SharedDataConfig(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Bean
	public FilterRegistrationBean<SharedDataFilter> sharedDataFilterRegistrationBean() {
		SharedDataFilter sharedDataFilter = new SharedDataFilter(categoryService);
		FilterRegistrationBean<SharedDataFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(sharedDataFilter);
		registrationBean.addUrlPatterns(UrlConstant.B2C_SHARED_DATA_URL);
		return registrationBean;
	}
}
