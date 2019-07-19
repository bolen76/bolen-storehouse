package com.bolen.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public interface MyMethodRefer {
	
	
	String apply(String t);
	
	public static void main(String[] args) {
		 
		MyMethodRefer mmr=String::toLowerCase;
		 String apply = mmr.apply("Hello");
		 System.out.println(apply);
		MethodBeRefer methodBeRefer = new MethodBeRefer();
		System.out.println(methodBeRefer.i);
		System.out.println();
		
		List<String> list=new ArrayList<>();
		
		list.forEach(String::toLowerCase);
		
		Consumer<String> c=String::toLowerCase;
		
		Function<String,String> f=String::toLowerCase;
		
		String result = f.apply("HELLO");
		System.out.println(result);
	}
}
