package com.janita.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * Created by Janita on 2017-05-25 19:38
 * 时区
 */
public class ZoneTest {

    @Test
    public void test1() {
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }

    @Test
    public void test2() {
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println("******* "+ ldt);

        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Asia/shanghai"));
        ZonedDateTime ztt = ldt2.atZone(ZoneId.of("Asia/shanghai"));
        System.out.println("******* " + ztt);
    }
}
