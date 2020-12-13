package com.example.demo.threadpool;

import java.util.concurrent.ThreadFactory;

public class CounterThreadFactory  implements ThreadFactory {

    //通过构造函数传递值，进行命名
    private String country;

    private String province;

    private String programName;

    private int counter;

    @Override
    public Thread newThread(Runnable runnable) {
        StringBuffer threadName = new StringBuffer();
        threadName.append(country).append("-").append(province).append("-").append(programName).append("-").append(counter);
        Thread thread  = new Thread(runnable,threadName.toString());
        counter++;
        return thread;
    }

    public CounterThreadFactory(String country, String province, String programName) {
        this.counter= 0;
        this.country = country;
        this.province = province;
        this.programName = programName;
    }
}
