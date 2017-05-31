package com.janita.java8.chapter2.assit;

import com.janita.java8.chapter2.assit.Apple;
import com.janita.java8.chapter2.assit.AppleFormatter;

/**
 * Created by Janita on 2017-05-30 10:25
 */
public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristic + " " + apple.getColor() + " apple";
    }
}
