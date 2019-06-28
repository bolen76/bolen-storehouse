package com.bolen.parameter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class ParameterDemo {
	
	@Test
	public void test01(){
		ConcurrentHashMap<Integer, String> productInfo = new ConcurrentHashMap<>();
		System.out.println(productInfo instanceof Map<?,?> );
	}
}	
