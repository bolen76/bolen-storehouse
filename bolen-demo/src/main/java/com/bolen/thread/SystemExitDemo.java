package com.bolen.thread;

public class SystemExitDemo {
    
    public static void main(String[] args) {
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程运行");
                System.exit(0);
            }
        }).start();
        
        System.out.println("主线程运行");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束休眠");
    }
}
