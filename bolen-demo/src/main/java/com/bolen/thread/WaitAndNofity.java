package com.bolen.thread;

public class WaitAndNofity {
    
    public static final Object LOCK = new Object();
    
    public static volatile int SINGAL = 1;
    
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask(1));
        Thread t2 = new Thread(new MyTask(2));
        Thread t3 = new Thread(new MyTask(3));
        t1.start();
        t2.start();
        t3.start();
    }
    
    
}

class MyTask implements Runnable {
    
    private int num;
    
    public MyTask(int num) {
        this.num = num;
    }
    
    @Override
    public void run() {
        while (true) {
            synchronized (WaitAndNofity.LOCK) {
                while (num != WaitAndNofity.SINGAL) {
                    try {
                        WaitAndNofity.LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
                if (num == 1) {
                    System.out.println("A");
                    WaitAndNofity.SINGAL = 2;
                } else if (num == 2) {
                    System.out.println("B");
                    WaitAndNofity.SINGAL = 3;
                } else if (num == 3) {
                    System.out.println("C");
                    WaitAndNofity.SINGAL = 1;
                }
                WaitAndNofity.LOCK.notifyAll();
            }
        }
        
    }
}