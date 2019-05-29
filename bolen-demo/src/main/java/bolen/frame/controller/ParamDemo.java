package bolen.frame.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import bolen.frame.model.UpmsUser;
import bolen.frame.service.UpmsUserService;

@Controller
@RequestMapping("/param")
public class ParamDemo {

	@Autowired
	UpmsUserService upmsUserService;

	@RequestMapping("/map")
	public ModelAndView mapParm(Integer userId) {
		System.out.println("hello map......");
/*		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();

		UpmsUserService upmsUserService = (UpmsUserService) wac.getBean("hello");
		// Person person = new Person("zhang", 30, "male");
*/
		// return person;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("hello", "handler3......3333333");
		// 指定逻辑视图名
		modelAndView.setViewName("springmvc.jsp");
		UpmsUser upmsUser = upmsUserService.findUserById(userId);
		System.out.println(upmsUser);
		return modelAndView;

	}

	@RequestMapping("/mapm")
	public ModelAndView mapParm(@RequestParam Map pa) {
		System.out.println("hello map......");

		// Person person = new Person("zhang", 30, "male");

		// return person;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("hello", "handler3......3333333");
		// 指定逻辑视图名
		modelAndView.setViewName("springmvc.jsp");
		test();
		return modelAndView;

	}

	public void test() {

	}
}
