package com.janita.stream;

import com.janita.bean.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Janita on 2017-05-25 11:02
 * 一：Stream 的三个操作步骤
 * 1.创建 Stream
 * 2. 中间操作
 * 3. 终止操作 （终端操作）
 *
 *
 */
public class TestStreamAPI1 {

    //创建 Stream
    @Test
    public void test1() {
        //1. 可以通过 Collection 系列集合提供的 stream(串行) 或 parallelStream(并行) 可以获取
        List<String> list = new ArrayList<>();
        list.stream();

        //2.通过 Arrays 中的静态方法 stream() 获取数组流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream = Arrays.stream(employees);

        //3.通过 Stream 类中的静态方法 of()
        Stream<String> streamStream = Stream.of("aa","bb","cc");

        //4.创建无限流
        //迭代
        Stream<Integer> stream1 = Stream.iterate(0,(x) -> x+2);
        stream1
                .limit(5)  //中间操作
                .forEach(System.out::println); //终止操作
        //生成
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

    }
}
