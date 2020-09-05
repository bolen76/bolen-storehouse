package com.bolen.jdk8;

public class SubClass implements InterA, InterB {
	String name;

	public static void main(String[] args) {
		InterA ia = new SubClass("hello");
		ia.defMethod();

		SubClass sc = new SubClass("world");
		sc.defMethod();

		sc.otherMethod();
	}

	public static void stm() {
		System.out.println("subclass stm");
		//InterB.super.defMethod();

	}

	public void otherMethod() {
		InterA.super.defMethod();
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
