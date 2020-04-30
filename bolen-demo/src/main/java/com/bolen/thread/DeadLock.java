package com.bolen.thread;

public class DeadLock {
	 Object lockfirst = new Object();
	 Object locksecond = new Object();

	public  void deadlock() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lockfirst) {

					System.out.println("获取锁：lockfirst");

					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (locksecond) {
						System.out.println("获取锁：locksecond");
					}
				}

			}
		});

		t1.start();

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (locksecond) {

					System.out.println("获取锁：locksecond");

					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (lockfirst) {
						System.out.println("获取锁：lockfirst");
					}
				}

			}
		});

		t2.start();

	}
	
	public static void main(String[] args) {
		new DeadLock().deadlock();;
	}
}
