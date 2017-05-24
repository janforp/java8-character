package com.janita.base.mook.date;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

/**
 * Created by Janita on 2017-05-24 15:34
 */
public class ClockTest {

    @Test
    public void clock() {

        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        System.out.println("*******" + millis);

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);

        System.out.println("*******" + legacyDate);
    }
}
