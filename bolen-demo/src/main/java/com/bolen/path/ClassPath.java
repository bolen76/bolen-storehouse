package com.bolen.path;

import java.net.URL;

import org.junit.Test;

public class ClassPath {
	
	@Test
	public void test01(){
		
		URL resource = ClassPath.class.getResource("/");
		URL resource2 = ClassPath.class.getResource("");
		
		URL resource3 = ClassPath.class.getClassLoader().getResource("/");
		URL resource4 = ClassPath.class.getClassLoader().getResource("");
		
		System.out.println(resource.getPath());
		System.out.println(resource2.getPath());
		System.out.println(resource3.getPath());
		System.out.println(resource4.getPath());
		
	}
}
