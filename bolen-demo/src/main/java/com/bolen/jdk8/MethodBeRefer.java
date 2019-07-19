package com.bolen.jdk8;

public class MethodBeRefer {
	int i=100;
	public static int add(int a,int b){
		return a+b	;
	}
	
	
	public int minus(int a, int b){
		return a-b;
	}
	
	
	public Integer inc(){
		i++;
		return i;
	}
}
