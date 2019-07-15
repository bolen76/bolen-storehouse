package com.bolen.oop;

public abstract class Person {
	
	static {
		System.out.println("fs111......");
	}

	private Person() {
		System.out.println("fc333......");
	}
	
	{
		System.out.println("fb222......");
	}
	
	public static void main(String[] args) {
		//Person person = new Person();
	}
	
}
