package com.bolen.jdk8;

public interface InterA {

	String name = "static name";

	default void defMethod() {

		System.out.println("InterA--------defMethod------" + this.toString());
	};

	public static void stm() {

		System.out.println("InterA-----stm");
	}

	// String abm();
	// 不能重写Object中的方法
	/*
	 * default boolean equals(Object o){ return true; }
	 */

	/*
	 * static boolean equals(Object o){ return true; }
	 */

	double aa = 1.74_567;
	int i = 123_45;
	int j = 1;

	public static void main(String[] args) {
		int k = i + j;
		System.out.println(k);
	}
}
