package com.bolen.oop;

public class Father {
	public String name="father";
	
	public void methodA(){
		System.out.println("father AAA......");
	}
	
	
	public void methodB(){
		System.out.println("father BBB......");
		this.methodA();
		System.out.println(this.name);
	}
}
