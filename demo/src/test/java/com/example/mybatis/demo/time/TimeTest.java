package com.example.mybatis.demo.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeTest {

    @Test
    public void timeTest() {
        String strDay = "20201222";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(strDay, df);

        LocalDate dateInput = LocalDate.parse("20201222", df);
        Assertions.assertEquals(true, dateInput.isBefore(date));
    }
}
