package com.janita.book.chapter8.test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Janita on 2017/6/4- 13:32
 * 该类是:
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x ;
        this.y = y ;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point moveRightBy(int x) {
        return new Point(this.x + x, y);
    }

    public final static Comparator<Point> compareByXAmdThenY = Comparator.comparing(Point::getX).thenComparing(Point::getY);

    public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
        return points.stream()
                .map(p -> new Point(p.getX() + x, p.getY()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
