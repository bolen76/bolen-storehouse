package com.bolen.springboot.service;

public class BigObject {
	
	private int[] bytearr=new int[10*1024*1014];
	
	private String[] strArray=new String[100*1024*1024];
	
	private String name="hello jvm!";
	
	private EmptyClass ec=new EmptyClass();
}
