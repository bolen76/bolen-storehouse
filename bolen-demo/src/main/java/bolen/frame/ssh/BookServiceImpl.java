package bolen.frame.ssh;

import org.springframework.beans.factory.annotation.Autowired;

import bolen.pojo.Book;


public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	public void updateAndSaveBook(Book book) {
		bookDao.saveBook(book);
		System.out.println("异常");
		int i=1/0;
		book.setName("事务中先插入后修改");
		bookDao.updateBook(book);
	}

}
