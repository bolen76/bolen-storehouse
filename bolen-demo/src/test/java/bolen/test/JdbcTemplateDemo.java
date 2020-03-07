package bolen.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bolen.ssm.service.BookService;

@Transactional
public class JdbcTemplateDemo {
	@Autowired
	BookService bookService;
	@Test
	public void test01(){
		System.out.println("hello world");
		bookService.updateBook();
	}
	
	
	@Test
	public void test02(){
		bookService.findBookByName("金瓶梅");
	}
}
