package com.janita.mook;

import org.junit.Test;

import java.util.function.Function;

/**
 * Created by Janita on 2017-05-24 12:47
 */
public class FunctionTest {

    /**
     * Functions接受一个参数，并产生一个结果。
     * 默认方法可以将多个函数串在一起（compse, andThen）
     */
    @Test
    public void testFunction() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        backToString.apply("123");     // "123"
    }
}
