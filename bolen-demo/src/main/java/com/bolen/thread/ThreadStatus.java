package com.bolen.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.locks.LockSupport;

public class ThreadStatus {
    
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("线程1");
        });
        t1.setName("t1");
        // t1.start();
        
        Thread t2 = new Thread(() -> {
            System.out.println("线程2");
            long sum = 0;
            long sum2 = 0;
            boolean flag = true;
            while (flag) {
                sum += 1;
                sum2 += 1;
            }
            System.out.println(sum + sum2);
        });
        t2.setName("t2");
        t2.start();
        
        Thread t3 = new Thread(() -> {
            System.out.println("线程3");
            BufferedReader br = null;
            String line = null;
            while (true) {
                try {
                    br = new BufferedReader(new InputStreamReader(ThreadStatus.class.getResourceAsStream("a.txt")));
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        t3.setName("t3");
        t3.start();
        
        Object lock = new Object();
        Thread t4 = new Thread(() -> {
            System.out.println("线程4");
            synchronized (lock) {
                System.out.println("线程4获取锁");
                sleep(1000 * 60 * 60 * 24);
            }
        });
        t4.setName("t4");
        t4.start();
        sleep(1000);
        Thread t5 = new Thread(() -> {
            System.out.println("线程5");
            synchronized (lock) {
                System.out.println("线程5获取锁");
            }
        });
        t5.setName("t5");
        t5.start();
        
        Object lock2 = new Object();
        Thread t6 = new Thread(() -> {
            System.out.println("线程6");
            synchronized (lock2) {
                System.out.println("线程6获取锁");
                try {
                    lock2.wait(1000 * 60);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("线程6结束");
        });
        t6.setName("t6");
        t6.start();
        sleep(1000);
        Thread t7 = new Thread(() -> {
            System.out.println("线程7");
            synchronized (lock2) {
                System.out.println("线程7获取锁");
                try {
                    lock2.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("线程7结束");
        });
        t7.setName("t7");
        t7.start();
        sleep(1000);
        Thread t8 = new Thread(() -> {
            System.out.println("线程8");
            synchronized (lock2) {
                System.out.println("线程8获取锁");
                sleep(1000 * 60 * 2);
            }
            System.out.println("线程8结束");
        });
        t8.setName("t8");
        t8.start();
        
        /*
         * interrupt 和 unpark都能唤醒park线程，但是interrupt的线程醒来不抛异常，也不清除中断标志，isInterrupted()=true;
         * 先interrupt后park，线程会立马唤醒
         *
         */
        Thread t9 = new Thread(() -> {
            System.out.println("t9 进入");
            LockSupport.park();
            System.out.println("t9 唤醒");
            System.out.println("t9 " + Thread.currentThread().isInterrupted());
        });
        t9.setName("t9");
        t9.start();
        sleep(1000);
        t9.interrupt();
        Thread t10 = new Thread(() -> {
            System.out.println("t10 进入");
            Thread.currentThread().interrupt();
            LockSupport.park();
            System.out.println("t10 唤醒");
            System.out.println("t10 " + Thread.currentThread().isInterrupted());
        });
        t10.setName("t10");
        t10.start();
        Thread t11 = new Thread(() -> {
            System.out.println("t11 进入");
            sleep(1000 * 10);
            LockSupport.park();
            System.out.println("t11 唤醒");
            System.out.println("t11 " + Thread.currentThread().isInterrupted());
        });
        t11.setName("t11");
        t11.start();
        LockSupport.unpark(t11);
        Thread t12 = new Thread(() -> {
            System.out.println("t12 进入");
            LockSupport.park();
            System.out.println("t12 唤醒");
            System.out.println("t12 " + Thread.currentThread().isInterrupted());
        });
        t12.setName("t12");
        t12.start();
        
        sleep(1000 * 60 * 60 * 24);
    }
    
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
