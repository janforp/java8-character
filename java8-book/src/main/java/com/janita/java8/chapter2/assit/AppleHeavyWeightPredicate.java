package com.janita.java8.chapter2.assit;

/**
 * Created by Janita on 2017-05-30 10:54
 */
public class AppleHeavyWeightPredicate implements ApplePredicate<Apple> {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150 ;
    }
}
