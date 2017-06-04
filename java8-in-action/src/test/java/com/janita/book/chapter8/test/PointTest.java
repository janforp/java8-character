package com.janita.book.chapter8.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Janita on 2017/6/4- 13:34
 * 该类是:
 */
public class PointTest {

    @Test
    public void moveRightBy() throws Exception {

        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRightBy(10);

        assertEquals(15, p2.getX());
        assertEquals(5, p2.getY());
    }

    @Test
    public void testComparingTwoPoints() {
        Point p1 = new Point(10, 15);
        Point p2 = new Point(10, 20);

        int result = Point.compareByXAmdThenY.compare(p1, p2);

        assertEquals(-1, result);
    }

    @Test
    public void moveAllPointsRightBy() throws Exception {

        List<Point> points = Arrays.asList(new Point(5, 5), new Point(10, 5));

        List<Point> expectedPoints = Arrays.asList(new Point(15, 5), new Point(20, 5));

        List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);

        assertEquals(expectedPoints, newPoints);
    }

}