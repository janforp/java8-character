package com.janita.mook.date;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * Created by Janita on 2017-05-24 16:04
 * LocalDate代表一个唯一的日期，如2014-03-11
 * 它是不可变的,完全模拟本地时间工作。
 * 此示例演示如何通过添加或减去天数,月数，
 * 年来计算新的日期。记住每一个操作都会返回一个新的实例。
 */
public class LocalDateTest {

    @Test
    public void localDate() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);    // FRIDAY
    }

    /**
     * 将字符串解析为LocalDate
     */
    @Test
    public void dateTimeFormatter() {
        DateTimeFormatter germanFormatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
        System.out.println(xmas);   // 2014-12-24
    }
}
