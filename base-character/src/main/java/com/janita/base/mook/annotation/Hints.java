package com.janita.base.mook.annotation;

import java.lang.annotation.Repeatable;

/**
 * Created by Janita on 2017-05-24 16:23
 * 在Java8中注解是可以重复的
 */
public @interface Hints {
    Hint[] value();
}

/**
 * Java8使我们能够使用相同类型的多个注解，
 * 通过@Repeatable声明注解
 */
@Repeatable(Hints.class)
@interface Hint {
    String value();
}
