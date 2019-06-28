package com.bolen.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
	private String name;

	public MyCallable(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Integer call() throws InterruptedException {
		System.out.println(this.name);
		Thread.sleep(10000);

		try {

			int i = 1 / 0;
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}

		return 10;
	}

}
