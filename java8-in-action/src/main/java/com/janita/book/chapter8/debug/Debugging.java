package com.janita.book.chapter8.debug;

import com.janita.book.chapter8.test.Point;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Janita on 2017/6/4- 13:56
 * 该类是:
 */
public class Debugging {

    public static void main(String[] args) {

        debug4();
    }


    public static void debug1() {
        List<Point> points = Arrays.asList(new Point(12, 2), null);
        points.stream().map(Point::getX).forEach(System.out::println);
    }

    public static void debug2() {
        List<Integer> numbers= Arrays.asList(1,2,3);
        numbers.stream()
                .map(Debugging::divideByZero)
                .forEach(System.out::println);
    }

    public static int divideByZero(int n) {
        return n / 0;
    }



    public static void debug3() {
        List<Integer> numbers = Arrays.asList(2,3,4,5);
        numbers.stream()
                .map(x -> x + 17)
                .filter(x -> x % 2 == 0)
                .limit(3)
                .forEach(System.out::println);
    }

    public static void debug4() {
        List<Integer> numbers = Arrays.asList(2,3,4,5);

        numbers.stream()
                .peek(x -> System.out.println("from stream : " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map : " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter : " + x))
                .limit(3)
                .peek(x -> System.out.println("after limit : " + x))
                .collect(Collectors.toList());
    }
}
