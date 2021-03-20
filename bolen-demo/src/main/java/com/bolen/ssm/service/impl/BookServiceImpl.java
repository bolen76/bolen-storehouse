package com.bolen.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolen.ssm.mapper.BookMapper;
import com.bolen.ssm.model.Book;
import com.bolen.ssm.service.BookService;

//@Transactional
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedTemplate;

	@Autowired
	BookMapper bookMapper;

	@Override
	public void updateBook() {
		String sql = "select * from book";

		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : list) {
			System.out.println(map.get("name"));
		}

		String updatesql = "update book set price=? where name=?";
		jdbcTemplate.update(updatesql, 999, "金瓶梅");
		int i = 1 / 0;
		jdbcTemplate.update(updatesql, 999, "玉浦团");
	}

	@Override
	public void findBookByName(String name) {
		String sql = "select * from book t where t.name=:name";
		Map params = new HashMap<>();
		params.put("name", name);
		List<Map<String, Object>> list = namedTemplate.queryForList(sql, params);
		for (Map map : list) {
			Object object = map.get("price");

			System.out.println(object);
		}

	}

	@Override
	public void addBook1() {
		bookMapper.insert(new Book(null, "三国演义", 1));
		int i = 1 / 0;
	}

	@Override
	@Transactional
	public void addBook2() {
		bookMapper.insert(new Book(null, "水浒传", 2));
		int i = 1 / 0;
	}

	@Override
	@Transactional(readOnly = true)
	public void addBook3() {
		bookMapper.insert(new Book(null, "西游记", 3));
		int i = 1 / 0;
	}

	@Override
	@Transactional(readOnly = false)
	public void addBook4() {
		bookMapper.insert(new Book(null, "红楼梦", 4));
		int i = 1 / 0;
	}

}
