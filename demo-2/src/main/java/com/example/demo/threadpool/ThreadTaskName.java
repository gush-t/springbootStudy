package com.example.demo.threadpool;

import java.util.concurrent.ThreadFactory;

public class ThreadTaskName implements ThreadFactory {

    private final String threadGroup = "testGroup-";

    private int threadNumber;


    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, threadGroup + threadNumber);
        return thread;
    }


    public int getThreadNumber() {
        return threadNumber;
    }


    public void setThreadNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }


    public String getThreadGroup() {
        return threadGroup;
    }

}
