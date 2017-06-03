package com.janita.java8.chapter6_collector;

import org.junit.Test;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Janita on 2017-06-01 22:53
 */
public class DishTest {

    @Test
    public void test1 () {

        Dish.menu
                .stream()
                .distinct()
                .count();
    }

    @Test
    public void test2 () {

        Integer sum = Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("********  " + sum);
    }

    @Test
    public void test3 () {
        IntSummaryStatistics summaryStatistics = Dish.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println("********  " + summaryStatistics );

        double avg = Dish.menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println("********  " + avg );
    }

    @Test
    public void test4 () {
        String names = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println("********  " + names);

        names = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(":"));
        System.out.println("********  " + names);

        names = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining("[", ",", "]"));
        System.out.println("********  " + names);
    }

    @Test
    public void test5 () {
        int sum = Dish.menu.stream().collect(Collectors.reducing(0,Dish::getCalories,(x, y) -> x + y));
        System.out.println("********  " + sum);
    }

    @Test
    public void test6 () {
         Optional<Dish> max = Dish.menu.stream().collect(Collectors.reducing((Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println("********  " +  max);
    }

    @Test
    public void test7 () {
        Dish.menu.stream().collect(Collectors.reducing("", Dish::getName, String::concat));
    }

    @Test
    public void test8 () {
        Dish.menu.stream().collect(
                Collectors.groupingBy(
                        Dish::getType,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparingInt(Dish::getCalories)
                                ),
                                Optional::get
                        )
                )
        );
    }

    @Test
    public void test () {
        System.out.println("********  " );
    }
}
