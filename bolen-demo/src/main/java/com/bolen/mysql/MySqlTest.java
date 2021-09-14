package com.bolen.mysql;

import com.bolen.SpringBootLaunch;
import com.bolen.ssm.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootLaunch.class)
public class MySqlTest {
    
    @Autowired
    BookService bookService;
    
    @Test
    public void test01() {
        bookService.deleteAndInsert();
    }
}
