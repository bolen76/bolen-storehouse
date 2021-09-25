package com.bolen.thread.mythreadpool;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyExecutor {
    
    /**
     * 线程数量
     */
    private final AtomicInteger thCount = new AtomicInteger(0);
    
    /**
     * 线程池状态
     */
    private final AtomicInteger thpState = new AtomicInteger(0);
    
    private static final int RUNNING = 0;
    
    private static final int SHUTDOWN = 1;
    
    private static final int STOP = 2;
    
    private static final int TERMINATED = 3;
    
    private final Set<Worker> workers = new HashSet<>();
    
    private final ReentrantLock mainLock = new ReentrantLock();
    
    private int corePoolSize;
    
    private int maxPoolSize;
    
    private long keepAliveTime;
    
    private RejectedExecutionHandler handler;
    
    private BlockingQueue<Runnable> workQueue;
    
    private static final boolean ONLY_ONE = true;
    
    public MyExecutor(int corePoolSize, int maxPoolSize, long keepAliveTime, BlockingQueue<Runnable> workQueue,
            RejectedExecutionHandler handler) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.workQueue = workQueue;
        this.handler = handler;
    }
    
    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }
        if (thpState.get() >= SHUTDOWN) {
            return;
        }
        
        if (thCount.get() < corePoolSize && addWorker(command, true)) {
            return;
        }
        
        if (!workQueue.offer(command) && !addWorker(command, false)) {
            reject(command);
        }
    }
    
    private void reject(Runnable command) {
        handler.rejectedExecution(command, this);
    }
    
    private boolean addWorker(Runnable firstTask, boolean core) {
        
        while (true) {
            if (thpState.get() >= SHUTDOWN) {
                return false;
            }
            int wc = thCount.get();
            if (wc >= (core ? corePoolSize : maxPoolSize)) {
                return false;
            }
            //并发修改
            if (compareAndIncreaseWorkerCount(wc)) {
                break;
            }
        }
        
        boolean workerStarted = false;
        boolean workerAdded = false;
        Worker worker = null;
        try {
            worker = new Worker(firstTask);
            Thread th = worker.thread;
            mainLock.lock();
            try {
                if (thpState.get() == RUNNING) {
                    if (th.isAlive()) {
                        throw new IllegalThreadStateException();
                    }
                    workers.add(worker);
                    workerAdded = true;
                }
                
            } finally {
                mainLock.unlock();
            }
            
            if (workerAdded) {
                th.start();
                workerStarted = true;
            }
            
        } finally {
            if (!workerStarted) {
                addWorkerFailed(worker);
            }
        }
        return workerStarted;
    }
    
    private void addWorkerFailed(Worker worker) {
        mainLock.lock();
        try {
            workers.remove(worker);
            decrementWorkCount();
            tryTerminate();
        } finally {
            mainLock.unlock();
        }
    }
    
    private void tryTerminate() {
        while (true) {
            int state = thpState.get();
            if (state == RUNNING || state == TERMINATED || (state == SHUTDOWN && !workQueue.isEmpty())) {
                return;
            }
            if (thCount.get() != 0) {
                interruptIdelWorkers(ONLY_ONE);
            }
            
            if (thpState.compareAndSet(state, TERMINATED)) {
                return;
            }
        }
    }
    
    private void interruptIdelWorkers(boolean onlyOne) {
        mainLock.lock();
        try {
            for (Worker worker : workers) {
                if (!worker.thread.isInterrupted() && worker.lock.tryLock()) {
                    try {
                        worker.thread.interrupt();
                        
                    } finally {
                        worker.lock.unlock();
                    }
                }
                if (onlyOne) {
                    break;
                }
            }
        } finally {
            mainLock.unlock();
        }
    }
    
    private boolean compareAndIncreaseWorkerCount(int expect) {
        return thCount.compareAndSet(expect, expect + 1);
    }
    
    public void shutDown() {
        mainLock.lock();
        
        try {
            advanceRunState(SHUTDOWN);
            interruptIdelWorkers();
        } finally {
            mainLock.unlock();
        }
        
        tryTerminate();
    }
    
    private void advanceRunState(int shutdown) {
        while (true) {
            int state = thpState.get();
            if (state >= shutdown || thpState.compareAndSet(state, SHUTDOWN)) {
                break;
            }
        }
    }
    
    private void interruptIdelWorkers() {
        interruptIdelWorkers(false);
        
    }
    
    private class Worker extends AbstractQueuedSynchronizer implements Runnable {
        
        final Thread thread;
        
        Runnable firstTask;
        
        Lock lock;
        
        public Worker(Runnable firstTask) {
            this.firstTask = firstTask;
            lock = new ReentrantLock();
            thread = new Thread(this);
        }
        
        
        @Override
        public void run() {
            runWorker(this);
        }
        
        
    }
    
    private void runWorker(Worker worker) {
        Thread wt = Thread.currentThread();
        Runnable task = worker.firstTask;
        worker.firstTask = null;
        boolean completedAbruptly = true;
        try {
            while (task != null || (task = getTask()) != null) {
                worker.lock.lock();
                if (thpState.get() >= STOP && !wt.isInterrupted()) {
                    wt.interrupt();
                }
                try {
                    task.run();
                } finally {
                    task = null;
                    worker.lock.unlock();
                }
            }
            completedAbruptly = false;
        } finally {
            processWorkerExit(worker, completedAbruptly);
        }
    }
    
    private void processWorkerExit(Worker worker, boolean completedAbruptly) {
        if (completedAbruptly) {
            decrementWorkCount();
        }
        
        mainLock.lock();
        try {
            workers.remove(worker);
        } finally {
            mainLock.unlock();
        }
        
        tryTerminate();
        
        if (thpState.get() < STOP) {
            if (!completedAbruptly && thCount.get() >= corePoolSize) {
                return;
            }
            
            addWorker(null, false);
        }
    }
    
    private Runnable getTask() {
        boolean timedOut = false;
        while (true) {
            if (thpState.get() >= STOP || (thpState.get() >= SHUTDOWN && workQueue.isEmpty())) {
                decrementWorkCount();
                return null;
            }
            
            int count = thCount.get();
            boolean timed = count > corePoolSize;
            if ((count > maxPoolSize || (timed && timedOut)) && (count > 1 || workQueue.isEmpty())) {
                if (compareAndDecreaseWorkCount(count)) {
                    return null;
                }
                continue;
            }
            
            try {
                Runnable commond = timed ? workQueue.poll(keepAliveTime, TimeUnit.MILLISECONDS) : workQueue.take();
                if (commond != null) {
                    return commond;
                }
                timedOut = true;
            } catch (InterruptedException e) {
                timedOut = false;
            }
        }
    }
    
    private void decrementWorkCount() {
        while (!compareAndDecreaseWorkCount(thCount.get())) {
        }
    }
    
    private boolean compareAndDecreaseWorkCount(int expect) {
        return thCount.compareAndSet(expect, expect - 1);
    }
    
    public boolean isShutdown() {
        return thpState.get() > RUNNING;
    }
    
    private BlockingQueue<Runnable> getQueue() {
        return workQueue;
    }
    
    public static class CallerRunPolicy implements RejectedExecutionHandler {
        
        @Override
        public void rejectedExecution(Runnable r, MyExecutor executor) {
            if (!executor.isShutdown()) {
                r.run();
            }
        }
    }
    
    public static class AbortPolicy implements RejectedExecutionHandler {
        
        @Override
        public void rejectedExecution(Runnable r, MyExecutor executor) {
            throw new RejectedExecutionException("Task " + r.toString() + " rejected from " + executor.toString());
        }
    }
    
    public static class DiscardPolicy implements RejectedExecutionHandler {
        
        /**
         * Does nothing, which has the effect of discarding task r.
         */
        public void rejectedExecution(Runnable r, MyExecutor executor) {
        }
    }
    
    public static class DiscardOldestPolicy implements RejectedExecutionHandler {
        
        
        /**
         * Obtains and ignores the next task that the executor would otherwise execute, if one is immediately available,
         * and then retries execution of task r, unless the executor is shut down, in which case task r is instead
         * discarded.
         *
         * @param r        the runnable task requested to be executed
         * @param executor the executor attempting to execute this task
         */
        public void rejectedExecution(Runnable r, MyExecutor executor) {
            if (!executor.isShutdown()) {
                executor.getQueue().poll();
                executor.execute(r);
            }
        }
    }
    
}
