package com.example.demo.threadpool;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Time;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestThreadPool {

    ThreadLocal<String> name = ThreadLocal.withInitial(() -> {
        return "nihao";
    });

    @Test
    public void threadTest() {
        Thread threadOne = new Thread(() -> System.out.println("nihao"));
        String a = "sdfsdfsdfssdfs";
        String d = a.toUpperCase();
        String number = "123";
        String b = number.toUpperCase();
        System.out.println(b);
        System.out.println(d);
        char c = 's';
        char[] charArray = a.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (c == charArray[i]) {
                count++;
            }
        }
        assertThat(6).isEqualTo(count);
    }

    @Test
    public void selectCharNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String sourceString = scanner.nextLine();
        System.out.println("请输入字符：");
        String targetString = scanner.nextLine();
        if (targetString.length() > 1) {
            System.out.println("您输入的不是字符");
            return;
        }
        System.out.println("匹配次数：" + calcatorCharNumber(sourceString, targetString));
    }

    /**
     * 计算目标字符出现在源字符串中的次数，不区分大小写
     *
     * @param sourceString
     * @param targetString
     * @return
     */
    public static int calcatorCharNumber(String sourceString, String targetString) {
        char[] charArray = sourceString.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (targetString.equalsIgnoreCase(String.valueOf(charArray[i]))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String sourceString = scanner.nextLine();
        System.out.println("请输入字符：");
        String targetString = scanner.nextLine();
        if (targetString.length() > 1) {
            System.out.println("您输入的不是字符");
            return;
        }
        System.out.println("匹配次数：" + calcatorCharNumber(sourceString, targetString));
    }

    public void StackTest() {
        Stack<String> stack = new Stack<>();
        stack.push("gushaohua");
        stack.push("gushaohua02");
        stack.push("gushaohua03");
        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            String string = (String) iterator.next();
            System.out.println(stack.peek());
            System.out.println(stack.pop());
        }
    }

    @Test
    public void threadInterruptTest() throws InterruptedException {
        Thread sleepThread = new Thread(() -> {
            while (true) {
                try {
                    //System.out.println("sleepThread:sleep");
                    Thread.sleep(100000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread busyThread = new Thread(() -> {
            while (true) {
                //System.out.println("busyThread:busy");
            }
        });
        sleepThread.setDaemon(true);
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("sleepThread:interruptBefore" + sleepThread.isInterrupted());
        System.out.println("busyThread:interruptBefore" + busyThread.isInterrupted());
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("sleepThread:" + sleepThread.isInterrupted());
        System.out.println("busyThread:" + busyThread.isInterrupted());
        TimeUnit.SECONDS.sleep(2);
    }

    public volatile boolean on = true;

    @Test
    public void stopThread() {
        Thread stopThread = new Thread(() -> {
            while (on) {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("running");
            }
        });
        stopThread.start();
        Assertions.assertEquals(false, stopThread.isInterrupted());
        Assertions.assertEquals("TIMED_WAITING", stopThread.getState().toString());
    }

    private static Object lock = new Object();

    private static boolean flag = true;

    @Test
    public void waitNotifyTest() {
        Thread waitThread = new Thread(() -> {
            while (flag) {
                synchronized (lock) {
                    try {

                        System.out.println("waitThread:wait");
                        lock.wait();
                        flag = true;
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread notifyThread = new Thread(() -> {
            while (flag) {

                System.out.println("waitThread:notify");
                synchronized (lock) {
                    lock.notify();
                    try {
                        waitThread.join();
                        Thread.sleep(1000);
                        flag = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        while (true) {
            waitThread.start();
            notifyThread.start();
        }
    }

    @Test
    public void threadPoolTest() throws ExecutionException, InterruptedException {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(20);
        AtomicInteger integer = new AtomicInteger(100);
        CounterThreadTask threadTask = new CounterThreadTask(integer);
        CounterReturnThreadTask returnTask = new CounterReturnThreadTask(integer);
        CounterThreadFactory threadFactory = new CounterThreadFactory("中国", "北京", "峰谷数据");
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                5, 10, 1000, TimeUnit.SECONDS, workQueue, threadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );
        threadPool.execute(threadTask);
        Future future = threadPool.submit(returnTask);
        Assertions.assertEquals(210, future.get());
    }

    @Test
    public void scheduleThreadTest() {
        System.out.println(Runtime.getRuntime().availableProcessors());
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(20);
        AtomicInteger integer = new AtomicInteger(100);
        CounterThreadTask threadTask = new CounterThreadTask(integer);
        CounterReturnThreadTask returnTask = new CounterReturnThreadTask(integer);
        CounterThreadFactory threadFactory = new CounterThreadFactory("中国", "北京", "峰谷数据");
        ScheduledThreadPoolExecutor schedulePool = new ScheduledThreadPoolExecutor(5, threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        //schedulePool.schedule(threadTask,0, TimeUnit.SECONDS);
        for (int i = 0; i < 100; i++) {
            schedulePool.scheduleAtFixedRate(threadTask, 0, 1, TimeUnit.SECONDS);

        }
        //System.out.println("1");
    }

}