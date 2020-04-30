package com.bolen.jdk8;

public class SubClass implements InterA, InterB {
	String name;

	public static void main(String[] args) {
		InterA ia = new SubClass("hello");
		ia.defMethod();

		SubClass sc = new SubClass("world");
		sc.defMethod();
		
		
	}

	public static void stm() {
		System.out.println("subclass stm");

	}

	@Override
	public void defMethod() {
		InterA.super.defMethod();
		InterB.super.defMethod();
		System.out.println("subclass method");
	}

	public SubClass(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "SubClass [name=" + name + "]";
	}

	
}
