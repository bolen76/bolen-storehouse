package com.bolen.thread;

public class TwoThreadPrint {
    
    
    public static void main(String[] args) {
        Object lock = new Object();
        
        Thread t1 = new Thread(new MyTask(1, true, lock));
        t1.start();
        
        Thread t2 = new Thread(new MyTask(2, false, lock));
        t2.start();
    }
    
    private static class MyTask implements Runnable {
        
        private int num;
        
        private final Object lock;
        
        private final boolean turn;
        
        private static volatile boolean flag = true;
        
        
        public MyTask(int num, boolean turn, Object lock) {
            this.num = num;
            this.turn = turn;
            this.lock = lock;
        }
        
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (flag ^ turn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        
                    }
                    
                    System.out.println(num);
                    flag = !flag;
                    lock.notifyAll();
                }
            }
            
            
        }
        
    }
}


