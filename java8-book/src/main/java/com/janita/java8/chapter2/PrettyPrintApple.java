package com.janita.java8.chapter2;

import com.janita.java8.chapter2.assit.Apple;
import com.janita.java8.chapter2.assit.AppleFancyFormatter;
import com.janita.java8.chapter2.assit.AppleFormatter;
import com.janita.java8.chapter2.assit.AppleSimpleFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janita on 2017-05-30 10:27
 */
public class PrettyPrintApple {
    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        Apple apple1 = new Apple();
        apple1.setWeight(200);
        apple1.setColor("red");
        inventory.add(apple1);

        Apple apple2 = new Apple();
        apple2.setWeight(100);
        apple2.setColor("green");
        inventory.add(apple2);

        prettyPrintApple(inventory,new AppleFancyFormatter());

        prettyPrintApple(inventory,new AppleSimpleFormatter());



    }
}
