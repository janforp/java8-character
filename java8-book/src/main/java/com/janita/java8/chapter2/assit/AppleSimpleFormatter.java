package com.janita.java8.chapter2.assit;

import com.janita.java8.chapter2.assit.Apple;
import com.janita.java8.chapter2.assit.AppleFormatter;

/**
 * Created by Janita on 2017-05-30 10:26
 */
public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + " g";
    }
}
