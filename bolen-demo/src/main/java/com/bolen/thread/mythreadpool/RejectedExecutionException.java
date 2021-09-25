package com.bolen.thread.mythreadpool;

public class RejectedExecutionException extends RuntimeException {
    
    private static final long serialVersionUID = -375805702767069545L;
    
    public RejectedExecutionException() {
    }
    
    public RejectedExecutionException(String message) {
        super(message);
    }
}
