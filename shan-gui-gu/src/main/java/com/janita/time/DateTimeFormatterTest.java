package com.janita.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Janita on 2017-05-25 19:31
 *
 * DateTimeFormatter :格式化时间／日期
 */
public class DateTimeFormatterTest {

    @Test
    public void test1() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();

        String strDate = ldt.format(dtf);
        System.out.println("******* "+ strDate);

        System.out.println("-----------------------------------------------");

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");

        strDate = ldt.format(dtf2);
        System.out.println("******* " + strDate);

        LocalDateTime newDate = ldt.parse(strDate,dtf2);
        System.out.println("******* "+ newDate);
    }
}
