package com.bolen.tomcat;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TomcatTestController {
	private static final AtomicInteger count = new AtomicInteger(0);
	private  Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/tomcat/test")
	public Integer test(Integer number) {
		int num = count.incrementAndGet();
		//log.info("===服务端第{}---{}次访问,",number,num);
		System.out.println("==========服务端第"+number+"---"+num+"次访问");
		log.info("==========服务端第"+number+"---"+num+"次访问");
		try {
			Thread.sleep(1000 * 60 * 2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return num;
	}
}
