package com.bolen.general;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ShutDownHookDemo {

	public static void main(String[] args) {
		ShutDownTask task = new ShutDownTask();
		Runtime.getRuntime().addShutdownHook(task);
		/*
		 * try { System.in.read(); } catch (IOException e1) { // TODO Auto-generated
		 * catch block e1.printStackTrace(); }
		 */

		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class ShutDownTask extends Thread {
	@Override
	public void run() {

		try {
			FileWriter fileWriter = new FileWriter(new File("a.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hello word!");

	}

}