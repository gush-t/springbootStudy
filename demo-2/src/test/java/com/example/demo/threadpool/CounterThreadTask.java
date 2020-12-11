package com.example.demo.threadpool;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterThreadTask implements Runnable {

    private AtomicInteger integer;

    //通过构造函数传递参数，和值，进行处理
    @Override
    public void run() {
        integer.addAndGet(10);
        System.out.println(integer.get());
    }

    public CounterThreadTask(AtomicInteger integer) {
        this.integer = integer;
    }
}
