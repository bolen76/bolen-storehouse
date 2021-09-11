package com.bolen.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

@Slf4j
public class ProducerAndConsumer {
    
    public static void main(String[] args) {
        
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        producerAndConsumer.waitTest();
        
    }
    
    volatile boolean flag = true;
    
    /*
     * 1）中断线程1时，锁被线程2持有，线程1状态由WAITING转为BLOCK,并依然停留在wait代码处,并且中断状态为true。
     * 2) 待线程2释放锁，线程1再去重新获取锁，并进入catch(InterruptedException e)代码区域,中断状态为false。
     */
    public void waitTest() {
        final Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                log.info("{}-进入synchronized", Thread.currentThread().getName());
                while (flag) {
                    try {
                        log.info("{}-进入wait", Thread.currentThread().getName());
                        lock.wait();
                    } catch (InterruptedException e) {
                        log.info("{}-中断wait", Thread.currentThread().getName());
                        log.info("{}-中断状态{}", Thread.currentThread().getName(), Thread.currentThread().isInterrupted());
                    }
                }
            }
            log.info("{}-运行结束", Thread.currentThread().getName());
        });
        t1.setName("线程t1");
        t1.start();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                log.info("{}-进入synchronized", Thread.currentThread().getName());
                try {
                    Thread.sleep(1000 * 60 * 10);
                } catch (InterruptedException e) {
                    log.info("{}-中断sleep1", Thread.currentThread().getName());
                }
                
                try {
                    Thread.sleep(1000 * 10 * 1);
                } catch (InterruptedException e) {
                    log.info("{}-中断sleep2", Thread.currentThread().getName());
                }
            }
            log.info("{}-运行结束", Thread.currentThread().getName());
        });
        t2.setName("线程t2");
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("{}-线程状态{}", t1.getName(), t1.getState());
        log.info("{}-线程状态{}", t2.getName(), t2.getState());
        
        try {
            Thread.sleep(1000 * 10 * 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
        t1.interrupt();
        t2.interrupt();
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("{}-线程状态{}", t1.getName(), t1.getState());
        log.info("{}-中断状态{}", t1.getName(), t1.isInterrupted());
        log.info("{}-线程状态{}", t2.getName(), t2.getState());
    }
    
    /**
     * 会抛出异常java.lang.IllegalMonitorStateException
     */
    public void notifyTest() {
        System.out.println("测试开始");
        this.notify();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("测试结束");
    }
    
    /**
     * 会卡在wait()方法，先notify后wait，无法唤醒
     */
    public synchronized void notifyTest0() {
        System.out.println("测试开始");
        this.notify();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("测试结束");
    }
}

class MyBlockQueue<T> {
    
    private final Object lock = new Object();
    
    private final Queue<T> queue;
    
    private volatile int size;
    
    private volatile int count;
    
    public MyBlockQueue(int size) {
        this.size = size;
        this.queue = new ArrayDeque<>(size);
    }
    
    public void offer(T t) {
        synchronized (lock) {
            while (count >= size) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.offer(t);
            count++;
            lock.notifyAll();
        }
    }
    
    
    public T take() {
        synchronized (lock) {
            while (count <= 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            lock.notifyAll();
            return queue.poll();
        }
    }
}
