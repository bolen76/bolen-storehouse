package com.bolen.ssm.service;

import com.bolen.pojo.Book;

public interface BookService {
		
	public void updateBook();
	public void findBookByName(String name);
	public void updateAndSaveBook(Book book);
	}
	