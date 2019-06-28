package com.bolen.ssm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class ItemHandler2 implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("hello", "world......");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}

}
