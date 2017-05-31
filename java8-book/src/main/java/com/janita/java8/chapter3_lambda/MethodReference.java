package com.janita.java8.chapter3_lambda;

import com.janita.java8.chapter2.assit.Apple;

import java.util.*;
import java.util.function.Function;

/**
 * Created by Janita on 2017-05-30 19:39
 */
public class MethodReference {

    public static List<String> sort(List<String> list) {
        list.sort(String::compareToIgnoreCase);
        return list;
    }

    public void test1() {
        Function<String, Integer> stringIntegerFunction =  Integer::parseInt;
    }

    public static void sort() {
        List<String> str = Arrays.asList("a","b","A","B");
        str = sort(str);
        str.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Apple> appleList = Apple.appleList();
        appleList.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getCountry));
        appleList.forEach(System.out::println);

    }
}
