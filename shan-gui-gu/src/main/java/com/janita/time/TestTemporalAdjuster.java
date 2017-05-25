package com.janita.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by Janita on 2017-05-25 18:34
 */
public class TestTemporalAdjuster {

    //TemporalAdjuster 时间校正器
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("******* " + ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println("******* "+ldt2);

        //下个周日的日期
        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("******* " + ldt3);

        //自定义: 下一个工作日是什么时候
        ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dow = ldt4.getDayOfWeek();
            if (dow.equals(DayOfWeek.FRIDAY)) {
               return ldt4.plusDays(3);
            }else if (dow.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            }else {
                return ldt4.plusDays(1);
            }
        });

        System.out.println("******* "+ ldt);
    }
}
