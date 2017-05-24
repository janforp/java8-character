package com.janita.base.mook.lambda;


import com.janita.base.bean.Person;

/**
 * Created by Janita on 2017-05-24 11:51
 * 定一个Person的工厂接口，用于创建Person
 */
public interface PersonFactory<P extends Person> {

    P create(String firstName, String lastName);
}
