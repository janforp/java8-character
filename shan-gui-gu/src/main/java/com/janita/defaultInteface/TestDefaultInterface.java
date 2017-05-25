package com.janita.defaultInteface;

/**
 * Created by Janita on 2017-05-25 17:39
 */
public class TestDefaultInterface {

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        //默认调用类中的方法
        String name = subClass.getName();
        System.out.println("******* "+ name);

        MyInterface.show();
    }
}
