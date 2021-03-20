package com.bolen.thread;

public class TowThread {

	public static void main(String[] args) {

		printer("a", "b", false);
	}

	public static void printer(String a, String b, boolean available) {
		Printer printer = new Printer(available);
		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					printer.print(a);
				}
			}
		});

		Thread th2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					printer.printOther(b);
				}
			}
		});

		th1.start();
		th2.start();
	}

	private static class Printer {
		private boolean available;

		public Printer(boolean available) {
			this.available = !available;
		}

		public synchronized void print(String desc) {
			while (this.available) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(desc);
			this.available = !this.available;
			this.notifyAll();

		}

		public synchronized void printOther(String desc) {
			while (!this.available) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(desc);
			this.available = !this.available;
			this.notifyAll();

		}
	}
}
