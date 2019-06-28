package bolen.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bolen.ssm.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext*.xml"})
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
