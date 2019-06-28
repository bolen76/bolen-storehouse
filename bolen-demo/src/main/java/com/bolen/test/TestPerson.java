package com.bolen.test;

public class TestPerson {
	
	public static String name;
	private int age;
	private final int weight;
	
	private static  String address;
	
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		TestPerson.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public TestPerson(int age, int weight) {
		super();
		this.age = age;
		this.weight = weight;
	}

	
	public static void method(){
		String s="hello";
		//getAge();
		getName();
		System.out.println("method.....");
	}
	
	public void function(){
		method();
		System.out.println("function");
	}
	
}
