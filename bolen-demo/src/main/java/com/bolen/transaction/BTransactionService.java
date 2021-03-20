package com.bolen.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolen.ssm.mapper.BookMapper;
import com.bolen.ssm.model.Book;

@Service
public class BTransactionService {
	@Autowired
	BookMapper bookMapper;

	@Transactional
	public void insert() {
		Book book = new Book(2, "玉蒲团", 200);

		bookMapper.insert(book);

		int i = 1 / 0;
	}
}
