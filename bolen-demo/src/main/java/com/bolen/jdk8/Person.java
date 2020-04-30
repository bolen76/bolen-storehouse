package com.bolen.jdk8;

@Ano("hello")
@Ano("world")
public class Person {

	public static void main(String[] args) {
		for (Ano an : Person.class.getAnnotationsByType(Ano.class)) {
			String value = an.value();
			System.out.println(value);
		}

	}
}
