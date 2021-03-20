package com.bolen.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OomDemo {

	public static void main(String[] args) {
		/*
		 * while (true) { li.add(new long[1024][1024]); }
		 */
		// test();
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(System.currentTimeMillis());

		UUID randomUUID = UUID.randomUUID();
		System.out.println(randomUUID.toString());
	}

	public static void test() {
		test();
	}

	public static void heapProf() {
		int num = 1000 * 1000;
		List<OomPo> list = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			list.add(new OomPo());
		}

		for (int i = 0; i < num; i++) {
			list.add(new OomPo("bolen", 30));
		}

		try {
			Thread.sleep(1000 * 60 * 60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static class OomPo {
		String name;
		long age;

		public OomPo(String name, long age) {
			super();
			this.name = name;
			this.age = age;
		}

		public OomPo() {

		}
	}
}
