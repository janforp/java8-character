package com.janita.mook;

import com.janita.bean.Person;

/**
 * Created by Janita on 2017-05-24 11:50
 *
 *  :: 表达式的使用
 *
 *  通过构造函数引用来把所有东西拼到一起，而不是手动实现工厂
 */
public class DoubleQuotation {

    public static void main(String[] args) {

        /**
         * 我们通过Person::new创建一个人的引用，
         * Java编译器会自动选择正确的
         * 构造函数匹配PersonFactory.create的返回
         */
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
    }
}




