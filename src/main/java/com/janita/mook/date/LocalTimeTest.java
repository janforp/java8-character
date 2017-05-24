package com.janita.mook.date;

import org.junit.Test;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * Created by Janita on 2017-05-24 15:59
 * LocalTime代表没有时区的时间，
 * 例如晚上10点或17:30:15
 */
public class LocalTimeTest {

    @Test
    public void localTime() {
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        LocalTime now1 = LocalTime.now(zone1);
        System.out.println("*******" + now1.getHour());

        ZoneId zone2 = ZoneId.of("Brazil/East");
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println("*******" + now2.getHour());

        System.out.println(now1.isBefore(now2));

        LocalTime now = LocalTime.now();
        System.out.println("*******" + now.getHour());

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween);
        System.out.println(minutesBetween);
    }
}
