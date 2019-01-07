package com.qetch.springmvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qetch.springmvc.controller.InputProductController;
import com.qetch.springmvc.controller.SaveProductController;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		
		String dispatchUrl = null;
		if ("product_input.action".equals(action)) {
			InputProductController controller = new InputProductController();
			dispatchUrl = controller.handleRequest(req, resp);
		} else if ("product_save.action".equals(action)) {
			SaveProductController controller = new SaveProductController();
			dispatchUrl = controller.handleRequest(req, resp);
		}
		
		if ("product_input.action".equals(action)) {
			dispatchUrl = "/WEB-INF/jsp/ProductForm.jsp";
		} else if ("product_save.action".equals(action)) {
			dispatchUrl = "/WEB-INF/jsp/ProductDetail.jsp";
		}
		
		if (dispatchUrl != null) {
			RequestDispatcher rd = req.getRequestDispatcher(dispatchUrl);
			rd.forward(req, resp);
		}
	}
}
