package com.example.demo.jdk;

import com.example.demo.entity.Student;
import org.junit.jupiter.api.Test;

import javax.management.monitor.CounterMonitor;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class JavaStreamStudyTest {

    private static String threadStrA = "a";
    private static String threadStrB = "b";

    @Test
    public void predicateTest() {
        //流式处理，中间操作（intermediate operation）和中止操作（terminal operation）
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 2, 6, 23};// 数组和list之间的转换
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(intArray));
        list.stream().filter(s -> s > 10).map(s -> {
            if (s > 10) {
                return 1314;
            } else {
                return 520;
            }
        }).limit(10).distinct().sorted().forEach(System.out::println);

    }

    @Test
    public void deadLockTest() {

        Thread threadA = new Thread(() -> {
            synchronized (threadStrA) {
                // Thread.currentThread().
                System.out.println("threadA --> threadA");
                synchronized (threadStrB) {
                    System.out.println("threadA --> threadB");
                }
            }
        });
        Thread threadB = new Thread(() -> {
            synchronized (threadStrB) {
                System.out.println("threadB --> threadB");
                synchronized (threadStrA) {
                    System.out.println("threadB --> threadA");
                }
            }
        });
        while (true) {
            threadA.start();
            threadB.start();
        }
    }

    @Test
    public void valueTest() {
        String a = "sdfsd";
        Student stu = new Student();
        modificationStu(stu);
        System.out.println(stu.toString());
    }

    private void modificationStu(Student stu) {
        stu.setId(1);
        stu.setName("Tom");
    }

    public static void main(String[] args) {
        //获取java线程managerBean
        ThreadMXBean managerThread = ManagementFactory.getThreadMXBean();
        //获取
        ThreadInfo[] threadInfoArray = managerThread.dumpAllThreads(true, true);
        for (int i = 0; i < threadInfoArray.length; i++) {
            System.out.println(threadInfoArray[i].toString());
        }
    }

}
