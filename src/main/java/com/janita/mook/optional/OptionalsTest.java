package com.janita.mook.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by Janita on 2017-05-24 12:53
 * Optionals是没有函数的接口，
 * 取而代之的是防止NullPointerException异常。
 * 这是下一节的一个重要概念，所以让我们看看如何结合Optionals工作
 *
 * Optional是一个简单的容器，
 * 这个值可能是空的或者非空的。
 * 考虑到一个方法可能会返回一个non-null的值，
 * 也可能返回一个空值。
 * 为了不直接返回null，我们在Java 8中就返回一个Optional。
 */
public class OptionalsTest {

    @Test
    public void testOptionals() {

        Optional<String> optional = Optional.of("bam");

        boolean isPre = optional.isPresent();           // true
        System.out.println("isPre*******" + isPre);

        String option = optional.get();                 // "bam"
        System.out.println("option*******" + option);

        String orElse = optional.orElse("fallback");    // "bam"
        System.out.println("orElse*******" + orElse);


        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }
}
