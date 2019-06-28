package com.bolen.thread;

public class StaticDeadLock {
	
	static String str1 = "c++";
	static String str2;
	static {
		Thread t = new Thread() {
			public void run() {
				System.out.println("进入run方法");
				System.out.println("1------" +  StaticDeadLock.class);
				//website = "www.leegang.org";
				System.out.println("hello world...");
				System.out.println("2------" +new StaticDeadLock());
				System.out.println("退出run方法");
			}
		};
		// t.start();
	/*	try {
			//t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		System.out.println(str1);
		System.out.println(str2);
	}
	
	static String str3= "java";

	public static void main(String args[]) {
		System.out.println("main：" + StaticDeadLock.str1);
	}

}
