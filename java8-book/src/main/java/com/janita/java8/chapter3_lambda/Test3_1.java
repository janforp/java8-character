package com.janita.java8.chapter3_lambda;

import com.janita.java8.chapter2.assit.Apple;

import java.util.concurrent.Callable;
import java.util.function.Predicate;

/**
 * Created by Janita on 2017-05-30 15:22
 */
public class Test3_1 {

    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("ni hao");

        runnable.run();

        process(() -> System.out.println(" sdfsdfsfsd "));
        process(() -> {});

        Predicate<Apple> predicate = (Apple apple) -> apple.getWeight() > 100 ;
    }

    public static void process (Runnable runnable) {
        runnable.run();
    }

    public Callable<String> fetch() {
        return () -> "t";
    }
}
