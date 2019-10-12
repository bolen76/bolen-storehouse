package com.bolen.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bolen.ssm.service.BookService;

@RestController
@RequestMapping("/rest")
public class PathController {
	@Autowired
	BookService bookService;

	@RequestMapping("/test")
	@ResponseBody
	public String queryBooks() {
		
		return "hello world";
	}

	@RequestMapping(value = "/test/sb")
	public String addBook() {

		return "hello sb";
	}
}
