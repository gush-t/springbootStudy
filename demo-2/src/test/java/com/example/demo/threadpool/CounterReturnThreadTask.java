package com.example.demo.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterReturnThreadTask implements Callable {
    //通过构造函数传递值，进行处理

    private AtomicInteger integer;

    @Override
    public Integer call() throws Exception {
        Integer number = integer.addAndGet(100);
        return number;
    }

    public CounterReturnThreadTask(AtomicInteger integer) {
        this.integer = integer;
    }
}
