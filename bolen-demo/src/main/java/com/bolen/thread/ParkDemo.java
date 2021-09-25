package com.bolen.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class ParkDemo {
    
    /*
     * interrupt 和 unpark都能唤醒park线程，但是interrupt的线程醒来不抛异常，也不清除中断标志，isInterrupted()=true;
     * 先interrupt后park，线程会立马唤醒
     *
     *
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.info("进入");
            LockSupport.park();
            log.info("唤醒");
            log.info(String.valueOf(Thread.currentThread().isInterrupted()));
        });
        t1.setName("t1");
        t1.start();
        
        Thread t2 = new Thread(() -> {
            log.info("进入");
            LockSupport.park();
            log.info("唤醒");
            log.info(String.valueOf(Thread.currentThread().isInterrupted()));
        });
        t2.setName("t2");
        t2.start();
        
        Thread t3 = new Thread(() -> {
            log.info("进入");
            Thread.currentThread().interrupt();
            LockSupport.park();
            log.info("唤醒");
            log.info(String.valueOf(Thread.currentThread().isInterrupted()));
        });
        t3.setName("t3");
        t3.start();
        
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
        
        }
        
        t1.interrupt();
        LockSupport.unpark(t2);
    }
}
