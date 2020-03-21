package com.bolen.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {
	
	private static final Logger log=LoggerFactory.getLogger(SpringBootController.class);
	@RequestMapping("/sbtest")
	public String test() {
		
		System.out.println("hello spring boot!");
		
		log.info("你是一个{}，难道不是{}?","sb","baichi");
		return "hello bolen";
	}
}
