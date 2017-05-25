package com.janita.stream.practice;

import com.janita.bean.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Janita on 2017-05-25 14:39
 *
 * stream API 的练习
 */
public class PracticeStreamAPI {

    /**
     * 1.给定一个数字列表，如何发挥一个由每个数的平方构成的列表呢？
     * 【1,2,3,4,5】，返回【1,4,9,16,25】
     */

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> integers = list.stream().map((Integer i) -> i * i).collect(Collectors.toList());
        integers.forEach(System.out::println);

        Integer[] nums = new Integer[]{1,2,3,4,5};
        Arrays.stream(nums).map((x) -> x *x).forEach(System.out::println);
    }

    /**
     * 2.怎么用 map 和 reduce 方法数一数流中有多少个 Employee 呢？
     */

    @Test
    public void test2() {

        List<Employee> employees = Employee.employeeList();
        Optional<Integer> count = employees.stream().map((e) -> 1).reduce(Integer::sum);
        System.out.println("******* " + count.get());
    }
}
