package bolen.frame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ItemHandler3 {
	//商品列表，@RequestMapping中url建议和方法名一致，方便开发维护
	@RequestMapping("/queryItems.action")
	public ModelAndView queryItems(){
		
	
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("hello", "handler3......3333333");
		//指定逻辑视图名
		modelAndView.setViewName("springmvc.jsp");

		return modelAndView;
	}
	
	//商品添加
	
	//商品删除 

	
}
