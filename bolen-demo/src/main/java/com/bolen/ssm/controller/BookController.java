package com.bolen.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bolen.pojo.Book;
import com.bolen.ssm.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService bookService;

	@RequestMapping("/modifyBook")
	public ModelAndView queryBooks(Book book,HttpServletRequest req) {
		String name = req.getParameter("name");
		System.out.println(name);

		ModelAndView andView = new ModelAndView();
		andView.setViewName("springmvc.jsp");
		return andView;
	}

	@RequestMapping(value = "/toAddBook")
	public ModelAndView addBook() {

		ModelAndView andView = new ModelAndView();
		andView.setViewName("ssh.jsp");
		return andView;
	}
	
	@RequestMapping(value = "/addBook1")
	public void addBook1() {
		bookService.addBook1();
	}
	
	@RequestMapping(value = "/addBook2")
	public void addBook2() {
		bookService.addBook2();
	}
	
	@RequestMapping(value = "/addBook3")
	public void addBook3() {
		bookService.addBook3();
	}
	
	@RequestMapping(value = "/addBook4")
	public void addBook4() {
		bookService.addBook4();
	}
}
