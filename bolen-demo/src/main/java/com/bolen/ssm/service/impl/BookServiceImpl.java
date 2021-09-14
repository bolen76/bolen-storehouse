package com.bolen.ssm.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.Null;
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
    
    /*
     isbn唯一字段，先删除isbn=119数据，后添加一条记录isbn=119数据，不管是否在同一个事务，都可以成功
     */
    @Override
    // @Transactional
    public void deleteAndInsert() {
        bookMapper.deleteByPrimaryKey(12);
        // int i = 1 / 0;
        bookMapper.insert(new Book(null, "红楼梦", new BigDecimal("10"), 119L, null));
    }
    
    
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
        bookMapper.insert(new Book(null, "三国演义", new BigDecimal(1), null, null));
        int i = 1 / 0;
    }
    
    @Override
    @Transactional
    public void addBook2() {
        bookMapper.insert(new Book(null, "水浒传", new BigDecimal(2), null, null));
        int i = 1 / 0;
    }
    
    @Override
    @Transactional(readOnly = true)
    public void addBook3() {
        bookMapper.insert(new Book(null, "西游记", new BigDecimal(3), null, null));
        int i = 1 / 0;
    }
    
    @Override
    @Transactional(readOnly = false)
    public void addBook4() {
        bookMapper.insert(new Book(null, "红楼梦", new BigDecimal(1), null, null));
        int i = 1 / 0;
    }
    
}
