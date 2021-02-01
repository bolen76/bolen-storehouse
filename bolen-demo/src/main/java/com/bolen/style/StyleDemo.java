package com.bolen.style;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StyleDemo<E, C> {
	private C c;
	private String name;

	private final int age = 18;

	public static String WEIGHT;

	public static final String LOVE_LANGUAGE = "hello world";

	@Autowired
	private List list;

	public static String smethod(String name) {
		WEIGHT = name;
		return name;
	}

	public <T> T get(T t, String param) {
		int a = 10;
		String hel = "c++";
		List<String> list = new ArrayList<>();
		List<String> other = new ArrayList<>();
		list.stream().forEach(item -> {
			other.add(item);
		});
		WEIGHT = "hello";
		smethod("helo");
		this.name = "java";
		return t;
	}

	public void set() {
		get(null, null);
	}

}
