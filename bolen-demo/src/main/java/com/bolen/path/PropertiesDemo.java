package com.bolen.path;

import java.util.ResourceBundle;

import org.junit.Test;

public class PropertiesDemo {

	public static void main(String args[]) {

		ResourceBundle bundle = ResourceBundle.getBundle("config");
		String string = bundle.getString("app.name");
		System.out.println(string);
		ResourceBundle.clearCache();
		ResourceBundle bundle2 = ResourceBundle.getBundle("config");
		String string2 = bundle2.getString("app.name");
		System.out.println(string2);
		System.out.println(bundle == bundle2);

	}
}
