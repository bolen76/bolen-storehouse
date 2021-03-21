package com.bolen;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(basePackages = {"com.bolen.**.mapper.**"})
@SpringBootApplication
public class SpringBootLaunch {
	private static final   Logger log=LoggerFactory.getLogger(SpringBootLaunch.class);
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootLaunch.class,args);
	}
}
