package com.bolen.ssm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bolen.ssm.model.UpmsUser;
import com.bolen.ssm.service.UpmsUserService;

@Controller
@RequestMapping("/param")
public class ParamDemo {

	@Autowired
	UpmsUserService upmsUserService;
	
	
	public ParamDemo() {
		super();
		System.out.println("hello world....ParamDemo");
	}
	@RequestMapping("/test")
	@ResponseBody
	public void test() {
		
		System.out.println("==========test========");
		
	}

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

}
