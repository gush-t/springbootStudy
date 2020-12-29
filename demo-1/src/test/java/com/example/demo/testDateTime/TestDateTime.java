package com.example.demo.testDateTime;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class TestDateTime {


    @Test
    public void testDate() {
        //字符串和日期之间的转换
        String strDay = "20190801";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        //字符串转换为日期
        LocalDate date = LocalDate.parse(strDay, dtf);
        System.out.println(date.toString());
        System.out.println(date.getMonthValue());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfYear());
        //日期转换为字符
        System.out.println(date.format(dtf));
    }

    @Test
    public void testCaculator() {
        double nubOne = 1;
        double nubTwo = 3;
        String operate = "+";
        Double resultDouble = 0d;
        String strOperate = "+-*/";
        if (strOperate.contains(operate.trim())) {
            resultDouble = 0d;
        }
        System.out.println(resultDouble);
    }

    @Test
    public void testFloatDouble() {
        double nub01 = 1.4;
        double nub02 = 1.9;
        assertThat(0.5).isEqualTo(nub02 - nub01);
        System.out.println(nub02 - nub01);
    }
}
