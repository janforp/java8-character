package com.janita.mook.date;

import org.junit.Test;

import java.time.ZoneId;

/**
 * Created by Janita on 2017-05-24 15:37
 */
public class TimezonesTest {

    @Test
    public void zone() {
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());
    }
}
