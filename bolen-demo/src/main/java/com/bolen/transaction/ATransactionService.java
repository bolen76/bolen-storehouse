package com.bolen.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolen.ssm.mapper.BookMapper;
import com.bolen.ssm.model.Book;

@Service
public class ATransactionService {

	@Autowired
	BookMapper bookMapper;

	@Autowired
	BTransactionService bts;

	@Transactional
	public void insert() {
		Book book = new Book(1, "金瓶梅", 100);

		bookMapper.insert(book);
		try {
			bts.insert();
		} catch (Exception ex) {
			System.out.println("bts, exception..........");
		}
		//int i = 1 / 0;
		System.out.println("ats, finished..........");
	}
}
