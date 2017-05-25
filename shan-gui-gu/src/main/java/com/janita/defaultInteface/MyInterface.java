package com.janita.defaultInteface;

/**
 * Created by Janita on 2017-05-25 17:40
 */
public interface MyInterface {

    default String getName() {
        return "呵呵呵";
    }

    static void show() {
        System.out.println("******* 接口中的静态方法");
    }
}
