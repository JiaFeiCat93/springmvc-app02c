package com.qetch.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qetch.springmvc.domain.Product;
import com.qetch.springmvc.form.ProductForm;

public class SaveProductController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ProductForm productForm = new ProductForm();
		productForm.setName(request.getParameter("name"));
		productForm.setDescription(request.getParameter("description"));
		productForm.setPrice(request.getParameter("price"));
		
		Product product = new Product();
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		product.setPrice(Float.parseFloat(productForm.getPrice()));
		
		// code to save product
		
		request.setAttribute("product", product);
		return "/WEB-INF/jsp/ProductDetail.jsp";
	}
	
}
