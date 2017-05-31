package com.janita.java8.chapter2;

import com.janita.java8.chapter2.assit.Apple;
import com.janita.java8.chapter2.assit.AppleGreenColorPredicate;
import com.janita.java8.chapter2.assit.AppleHeavyWeightPredicate;
import com.janita.java8.chapter2.assit.ApplePredicate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Janita on 2017-05-30 10:35
 */
public class FilteringApples {

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate<Apple> predicate) {
        return inventory.stream().filter(predicate::test).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple("green",80),
                                                new Apple("green", 155),
                                                new Apple("red", 120));

        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        heavyApples.forEach(System.out::println);

        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
        greenApples.forEach(System.out::println);

        System.out.println("***********    ");
        List<Apple> result = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        result.forEach(System.out::println);

    }
}
