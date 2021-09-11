package com.bolen.jvm;

import java.lang.ref.WeakReference;

public class ReferenceDemo {

	public static void main(String[] args) {
		WeakReference<String> wr = new WeakReference<String>(new String("hello world"));
		System.out.println(wr.get());

		System.gc();
		System.out.println(wr.get());
	}
}
