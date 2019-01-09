package com.qetch.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qetch.springmvc.domain.Product;
import com.qetch.springmvc.form.ProductForm;
import com.qetch.springmvc.validator.ProductValidator;

public class SaveProductController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ProductForm productForm = new ProductForm();
		productForm.setName(request.getParameter("name"));
		productForm.setDescription(request.getParameter("description"));
		productForm.setPrice(request.getParameter("price"));
		
		ProductValidator validator = new ProductValidator();
		List<String> errors = validator.validate(productForm);
		if (errors.isEmpty()) {
			Product product = new Product();
			product.setName(productForm.getName());
			product.setDescription(productForm.getDescription());
			product.setPrice(Float.parseFloat(productForm.getPrice()));
			
			// code to save product
			
			request.setAttribute("product", product);
			return "/WEB-INF/jsp/ProductDetail.jsp";
		} else {
			request.setAttribute("errors", errors);
			request.setAttribute("form", productForm);
			return "/WEB-INF/jsp/ProductForm.jsp";
		}
	}
	
}
