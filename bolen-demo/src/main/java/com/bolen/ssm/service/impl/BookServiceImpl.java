package com.bolen.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.bolen.pojo.Book;
import com.bolen.ssm.service.BookService;

//@Transactional
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedTemplate;

	@Override
	public void updateBook() {
		String sql = "select * from book";

		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : list) {
			System.out.println(map.get("name"));
		}
		
		String updatesql="update book set price=? where name=?";
		jdbcTemplate.update(updatesql, 999,"金瓶梅");
		int i=1/0;
		jdbcTemplate.update(updatesql, 999,"玉浦团");
	}

	@Override
	public void findBookByName(String name) {
		String sql="select * from book t where t.name=:name";
		Map params=new HashMap<>();
		params.put("name", name);
		List<Map<String,Object>> list = namedTemplate.queryForList(sql, params);
		for(Map map:list){
			Object object = map.get("price");
			
			System.out.println(object);
		}
		
	}

	@Override
	public void updateAndSaveBook(Book book) {
		// TODO Auto-generated method stub
		
	}

}
