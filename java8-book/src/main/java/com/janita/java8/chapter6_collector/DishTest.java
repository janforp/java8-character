package com.janita.java8.chapter6_collector;

import org.junit.Test;

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
}
