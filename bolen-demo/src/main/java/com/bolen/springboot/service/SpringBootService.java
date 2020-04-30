package com.bolen.springboot.service;

import org.springframework.stereotype.Service;

import com.bolen.thread.DeadLock;

@Service
public class SpringBootService {
	
	
	public void jvmAnalyze() {
		BigObject bo=new BigObject();
				
		
		try {
			Thread.sleep(1000*60*60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deadlock() {
		DeadLock deadLock = new DeadLock();
		
		deadLock.deadlock();
	}
	
	
	public void busycpu() {
		long i=0;
		while(true) {
			System.out.println(i++);
		}
	}
}
