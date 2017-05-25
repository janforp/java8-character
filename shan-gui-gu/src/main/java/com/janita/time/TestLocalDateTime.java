package com.janita.time;

import org.junit.Test;

import java.time.*;

/**
 * Created by Janita on 2017-05-25 18:13
 */
public class TestLocalDateTime {

    //1.LocalDate LocalTime LocalDateTime
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("******* "+ ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2015,10,19,13,22,33);
        System.out.println("******* "+ ldt2);

        LocalDateTime ldt3 = ldt.plusYears(2);
        System.out.println("******* "+ ldt3);

        LocalDateTime ldt4 =ldt.minusMonths(2);
        System.out.println("******* " + ldt4);

        System.out.println("******* "+ ldt.getYear());
        System.out.println("******* "+ ldt.getMonthValue());
        System.out.println("******* "+ ldt.getDayOfMonth());
        System.out.println("******* "+ ldt.getHour());
        System.out.println("******* "+ ldt.getMinute());
        System.out.println("******* "+ ldt.getSecond());
    }

    //2.时间戳: Instant,一unix元年 ：1970.1.1 0:0:0 到当前的毫秒值
    @Test
    public void test2() {
        //默认获取的是以 UTC 时区
        Instant ins1 = Instant.now();
        System.out.println("******* " + ins1);

        OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println("******* " + odt);

        System.out.println("******* " + ins1.toEpochMilli());

        Instant ins2 = Instant.ofEpochSecond(60);
        System.out.println("******* "+ ins2);
    }

    //3.Duration : 计算两个 时间 之间的间隔

    @Test
    public void test3() throws InterruptedException {
        Instant ins1 = Instant.now();
        Thread.sleep(1000);
        Instant ins2 = Instant.now();

        Duration duration = Duration.between(ins1,ins2);
        System.out.println("******* " + duration.toMillis());
    }
    //4.Period : 计算两个 日期之间的间隔
}
