package com.janita.stream;

import com.janita.bean.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Janita on 2017-05-25 11:19
 *
 * Stream 的中间操作
 * 1.筛选
 * 2.隐射
 * 3.排序
 * ....
 */
public class TestStreamAPI2 {

    private List<Employee> employees = Employee.employeeList();

    /**
     * 筛选与切片
     * filter -- 接收 Lambda, 从流中排除某些元素
     * limit -- 截断流， 使其元素不超过给定数量
     * skip(n) -- 跳过元素，返回一个扔掉了前 n 个元素的流， 若流中元素不足 n 个，则返回一个空流，与 limit(n) 互补
     * distinct -- 筛选，通过流所生成元素的 hashcode() 和 equals() 去除重复元素
     */


    /**
     * 隐射
     * map -- 接收 Lambda ，将原始转换成其他形式或提取信息。
     * 接收一个函数作为参数，该函数会被应用到每个元素上，
     * 并将其隐射成一个新的元素。
     *
     * flatMap -- 接收一个函数作为参数，
     * 将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */


    /**
     * 中间操作不会执行任何操作
     * 终止操作执行全部
     * 内部迭代： 迭代操作由 Stream API 完成
     */
    @Test
    public void test1() {

        //过滤之后还是产生一个新的流,不会有任何结果（不会输出打印的文字）
        Stream<Employee> stream = employees
                .stream()
                .filter(e -> {
                                //在终止操作的时候才真正的执行
                                System.out.println("Stream API 的中间操作");
                                return e.getAge() > 35;
                            });
        //但是在终止操作的时候就会打印出中间操作的输出
        stream.forEach(System.out :: println);
    }

    /**
     * 外部迭代
     */
    @Test
    public void test2() {
        //iterator
    }

    @Test
    public void test3() {
        employees
                .stream()
                .filter(e -> { System.out.println("短路"); return e.getSalary() > 5000; })
                .limit(2)   //找到满足条件的两条数据之后就不会再往下迭代了，直接返回2条即可
                .forEach(System.out :: println);
    }

    @Test
    public void test4() {
        employees
                .stream()
                .filter(e -> e.getSalary() > 5000)
                .skip(2)
                .distinct() //对 hashcode..
                .forEach(System.out :: println);
    }


    /************************隐射***********************/

    @Test
    public void test5() {
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out :: println);

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out :: println);

        //流集合中也是流
        Stream<Stream<Character>> stream = list.stream().map(TestStreamAPI2 :: filterCharacter);
        stream.forEach(sm -> sm.forEach(System.out :: println));

        System.out.println("*******flatMap************");

        //把多个 stream 合并为一个 stream
        Stream<Character> characterStream = list.stream().flatMap(TestStreamAPI2 :: filterCharacter);
        characterStream.forEach(System.out :: println);
    }

    /**
     * @param str
     * @return
     */
    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()){
            list.add(ch);
        }
        return list.stream();
    }
}
