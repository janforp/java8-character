package com.janita.defaultInteface;

/**
 * Created by Janita on 2017-05-25 17:36
 */
public interface MyFun {

    //默认方法
    default String getName() {
        return "哈哈哈";
    }
}
