package com.bolen.common;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneralRule {
	public void test() {

		for (int i = 0, n = 100; i < n; i++) {
			int nextInt = new Random().nextInt(100);
		}
		
		
		ThreadLocalRandom tlr=ThreadLocalRandom.current();
		
		throw new IllegalArgumentException();
	}
}
