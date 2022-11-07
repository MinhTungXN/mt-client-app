package com.vu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;

import com.vu.constant.AttributeConstant;
import com.vu.service.CategoryService;

@Configuration
public class SharedDataFilter implements Filter {
	
	private final CategoryService categoryService;
	
	public SharedDataFilter(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public void doFilter(ServletRequest servletRequest, 
						 ServletResponse servletResponse, 
						 FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		request.setAttribute(AttributeConstant.B2C_ALL_CATEGORIES_ATTRIBUTE, categoryService.getCategories());
		
		filterChain.doFilter(request, response);
	}

}
