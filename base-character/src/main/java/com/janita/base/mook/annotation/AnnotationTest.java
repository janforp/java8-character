package com.janita.base.mook.annotation;


import org.junit.Test;

/**
 * Created by Janita on 2017-05-24 16:26
 */
public class AnnotationTest {

    @Test
    public void annotation() {
        Hint hint = People.class.getAnnotation(Hint.class);
        System.out.println(hint);                   // null



        Hint[] hints2 = People.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);

        Hints hints1 = People.class.getAnnotation(Hints.class);
        System.out.println(hints1.value().length);  // 2
    }
}
