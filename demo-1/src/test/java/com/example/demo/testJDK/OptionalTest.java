package com.example.demo.testJDK;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.example.demo.dao.Student;

public class OptionalTest {


    @Test
    public void testOptionalEmpty() {
        Student stu01 = new Student();
        String testEmpty = "";
        Optional.of(testEmpty);
        System.out.println(stu01.toString());
        Student stu02 = new Student(12, "股说话");
        Optional<Student> empty = Optional.empty();
        //Optional.of(stu01.getId());
        Optional.of(stu02);
        Optional.ofNullable(stu01.getId()).orElseGet(() -> 1);
        Optional.ofNullable(stu02.getId()).orElse(12);
        Optional.ofNullable(stu02).filter(s -> s.getId() > 1).map(s -> s.getName()).orElse("nihao");
    }


}
