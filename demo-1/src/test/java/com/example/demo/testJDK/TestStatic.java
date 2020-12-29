package com.example.demo.testJDK;

import org.junit.jupiter.api.Test;

import com.example.demo.dao.Student;

public class TestStatic {

    public static int a = 0;

    public final int b = 2;

    public static final int C = 4;

    public int d = 5;

    public static String strStatic = "static";
    public static final String STRSTATICFINAL = "staticFinal";
    public final String strFinal = "final";

    public Student stu;

    public static Student stuStatic;

    public static final Student stuStaticFinal = new Student();

    public final Student stuFinal = new Student();


    public static void testStatic() {


    }

    @Test
    public void testFinal() {
        stuStatic = new Student();

        System.out.println(stuStatic.toString());
    }

}