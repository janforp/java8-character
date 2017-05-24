package com.janita.base.mook.date;

import org.junit.Before;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * Created by Janita on 2017-05-24 16:09
 * LocalDateTime代表日期时间。
 * 它结合了日期和时间
 * LocalDateTime是不可变的,
 * 类似于本地时间和LocalDate工作
 * 我们可以从一个日期时间获取某些字段的方法:
 */
public class LocalDateTimeTest {

    LocalDateTime sylvester = null;

    @Before
    public void init() {
        sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
    }

    @Test
    public void localDateTime() {

        sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek);      // WEDNESDAY

        Month month = sylvester.getMonth();
        System.out.println(month);          // DECEMBER

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);    // 1439
    }

    /**
     * 随着一个时区可以转换为一个即时的附加信息。
     * Instance可以被转换为日期型转化为指定格式的java.util.Date
     */
    @Test
    public void instant() {
        Instant instant = sylvester
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);
    }


    /**
     * 格式日期时间对象就像格式化日期对象或者格式化时间对象，
     * 除了使用预定义的格式以外，
     * 我们还可以创建自定义的格式化对象，
     * 然后匹配我们自定义的格式
     */
    @Test
    public void formatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
        String string = formatter.format(parsed);
        System.out.println(string);
    }
}
