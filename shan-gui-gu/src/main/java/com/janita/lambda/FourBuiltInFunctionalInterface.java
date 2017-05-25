package com.janita.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by Janita on 2017-05-25 09:14
 *
 * Consumer<T> : 消费型接口
 *      void accept(T t)
 * @see java.util.function.Consumer;
 *
 * Supplier<T> : 供给型接口
 *      T get()
 * @see java.util.function.Supplier;
 *
 *  Function<T, R> : 函数型接口
 *      R apply(T t)
 * @see java.util.function.Function;
 *
 *  Predicate(T)    :断言型接口
 *      boolean test(T t)
 *
 *
 */
public class FourBuiltInFunctionalInterface {

    /**
     * 消费money
     * @param money
     * @param con
     */
    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
    @Test
    public void testConsumer() {
        happy(10000, m -> System.out.println("大保健消费金额： " + m + " 元"));
    }


    /**
     * 产生一些整数，并放入集合中
     * @param num   传入的参数
     * @param sup   对象生成器
     * @return
     */
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            //具体产生什么样的数，则由具体的lambda表达式实现
            list.add(sup.get());
        }
        return list;
    }

    @Test
    public void supply() {
        List<Integer> list = getNumList(10, () -> (int)(Math.random()*100));
        System.out.println("*******"+ list);
    }

    /**
     * 函数型接口
     * 用于处理字符串，产生一个字符串，
     * 但是具体怎么处理由具体的函数式接口的实现来做
     */
    public String strHandler (String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    @Test
    public void function() {
        String string = strHandler("\t\t\t注发斯蒂芬是否   ", String::trim);
        System.out.println(string);

        string = strHandler("注发斯蒂芬是否", (str) -> str.substring(2,5));
        System.out.println("*******" + string);
    }


    /**
     * 处理字符串
     * 将满足条件的字符串添加到集合中
     */
    public List<String> strFilter(List<String> list, Predicate<String> pre) {
        List<String> stringList = new ArrayList<>();
        for (String str: list) {
            //如果满足某一个过滤条件，则通过
            if (pre.test(str)) {
                stringList.add(str);
            }
        }
        return stringList;
    }

    @Test
    public void predicate() {
        List<String> list = Arrays.asList("aaa","fgffffff","cccccc","d","s","dfsdfsdfs");
        //过滤出字符串长度 > 3 的字符串
        list = strFilter(list,(str) -> str.length()>3);
        System.out.println("*******"+ list);
    }
}
