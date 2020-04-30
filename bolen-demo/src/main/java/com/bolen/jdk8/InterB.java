package com.bolen.jdk8;

public interface InterB {

	default void defMethod() {

		System.out.println("InterB--------defMethod------" + this.toString());
	};

	public static void stm()  {
		System.out.println("InterB-----stm");
	}
}
