package com.janita.annotation;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by Janita on 2017-05-25 19:44
 *
 * 重复注解与类型注解
 */
public class AnnotationTest {

    //checker framework
    private /*@NonNull*/ Object obj = null;

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(@MyAnnotation("abc") String str) {}

    @Test
    public void test1() throws NoSuchMethodException {
        Class<AnnotationTest> clazz = AnnotationTest.class;
        Method m1 = clazz.getMethod("show");

        MyAnnotation[] mas = m1.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : mas) {
            System.out.println("******* " + myAnnotation.value());
        }
    }
}
