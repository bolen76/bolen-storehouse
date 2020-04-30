package com.bolen.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolen.springboot.service.SpringBootService;

@RestController
public class SpringBootController {
	
	private static final Logger log=LoggerFactory.getLogger(SpringBootController.class);
	@Autowired
	SpringBootService sbs; 
	@RequestMapping("/sbtest")
	public String test() {
		
		System.out.println("hello spring boot!");
		
		log.info("你是一个{}，难道不是{}?","sb","baichi");
		return "hello bolen";
	}
	
	@RequestMapping("/jvmanalyze")
	public String jvmAnalyze() {
		
		System.out.println("hello jvmanalyze!");
		sbs.jvmAnalyze();
		return "hello bolen";
	}
	
	@RequestMapping("/deadlock")
	public String deadlock() {
		
		System.out.println("hello deadlock!");
		sbs.deadlock();
		
		return "deadlock demo!";
	}
	
	@RequestMapping("/cpubusy")
	public void cpubusy() {
		
		System.out.println("hello cpubusy!");
		sbs.busycpu();
		
	}
}
