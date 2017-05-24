package com.janita.lambda.odlway;

/**
 * Created by Janita on 2017-05-24 22:04
 * 用于过滤 Employee
 */
@FunctionalInterface
public interface MyPredicate<T> {

    boolean test(T t);
}
