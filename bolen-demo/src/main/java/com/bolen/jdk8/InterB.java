package com.bolen.jdk8;

public interface InterB {

	default String methodB(){
		
		return "InterB--------method";
	};
	
	public static String methodC(){
		return "";
	}
}
