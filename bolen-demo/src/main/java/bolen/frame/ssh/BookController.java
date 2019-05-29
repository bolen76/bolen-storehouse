package bolen.frame.ssh;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bolen.pojo.Book;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService bookService;

	@RequestMapping("/modifyBook")
	public ModelAndView queryBooks(Book book,HttpServletRequest req) {
		String name = req.getParameter("name");
		System.out.println(name);
		bookService.updateAndSaveBook(book);

		ModelAndView andView = new ModelAndView();
		andView.setViewName("springmvc.jsp");
		return andView;
	}

	@RequestMapping(value = "/toAddBook")
	public ModelAndView addBook() {

		ModelAndView andView = new ModelAndView();
		andView.setViewName("ssh.jsp");
		return andView;
	}
}
