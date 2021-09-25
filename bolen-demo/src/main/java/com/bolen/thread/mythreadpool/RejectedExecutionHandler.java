package com.bolen.thread.mythreadpool;

public interface RejectedExecutionHandler {
    
    void rejectedExecution(Runnable r, MyExecutor executor);
}
