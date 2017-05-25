package com.janita.defaultInteface;

/**
 * Created by Janita on 2017-05-25 17:38
 */
public class SubClass /*extends MyClass*/ implements MyFun,MyInterface{

    @Override
    public String getName() {
        return MyInterface.super.getName();
    }
}
