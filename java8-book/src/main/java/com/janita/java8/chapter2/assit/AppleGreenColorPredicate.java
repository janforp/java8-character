package com.janita.java8.chapter2.assit;

import com.janita.java8.chapter2.assit.Apple;
import com.janita.java8.chapter2.assit.ApplePredicate;

/**
 * Created by Janita on 2017-05-30 10:34
 */
public class AppleGreenColorPredicate implements ApplePredicate<Apple> {

    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
