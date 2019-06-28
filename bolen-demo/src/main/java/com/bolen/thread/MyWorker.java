package com.bolen.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyWorker {
	private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS,
			new LinkedBlockingQueue<Runnable>(1));
	static {
		// 饱和策略为抛出异常
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
	}

	public static Future<?> submit(Runnable task) {
		Future<?> submit = executor.submit(task);
		return submit;
	}

	public static void shutdown() {
		executor.shutdown();
	}

	public static void main(String[] args) {
		MyCallable myCallable = new MyCallable("c hello");
		MyCallable myCallable2 = new MyCallable("c java");
		MyCallable myCallable3 = new MyCallable("c C++");
		
		
		MyRunnable myRunnable = new MyRunnable("r php");
		MyRunnable myRunnable2 = new MyRunnable("r js");
		MyRunnable myRunnable3 = new MyRunnable("r go");
		
//		Future<?> submit = MyWorker.submit(myCallable);
//		Future<?> submit2 = MyWorker.submit(myCallable2);
		Future<?> submit = MyWorker.submit(myRunnable);
		Future<?> submit2 = MyWorker.submit(myRunnable2);
		try {
			System.out.println(submit.isDone());
			Object object = submit.get();
			System.out.println(object);
			System.out.println(submit.isDone());
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyWorker.submit(myRunnable3);
		System.out.println("main thred finished......");
		
	//	Future<?> submit3 = MyWorker.submit(myCallable3);
//		try {
		//	Object object = submit.get();
//			System.out.println(object);
//			Object object2 = submit2.get();
//			System.out.println(object2);
		//	Object object3 = submit3.get();
			//System.out.println(object3);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		

	}
}
