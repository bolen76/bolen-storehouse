package bolen.frame.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ItemHandler implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView andView=new ModelAndView();
		andView.addObject("hello", "item handler......asekhfak;shf;klasf");
		andView.setViewName("springmvc");
		return andView;
	}



}
