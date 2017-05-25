package com.janita.stream;

import com.janita.bean.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Janita on 2017-05-25 13:50
 *
 * 收集
 * collect -- 将流转换成其他形式，接收一个 Collector 接口的实现，
 * 用于给 Stream 中的原始做汇总的方法
 *
 * @see java.util.stream.Collectors
 */
public class TestStreamAPICollect {

    private List<Employee> employees = Employee.employeeList();

    @Test
    public void test1() {
        List<String> stringList = employees.stream().map(Employee::getName).collect(Collectors.toList());
        stringList.forEach(System.out::println);
        //去重
        Set<String> stringSet = employees.stream().map(Employee::getName).collect(Collectors.toSet());
        stringSet.forEach(System.out::println);
        //放进 hashSet 中
        HashSet<String> hashSet = employees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);
    }

    @Test
    public void test2() {
        //总数
        Long count = employees.stream().collect(Collectors.counting());
        System.out.println("******* " + count);

        //平均值
        Double salary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("******* " + salary);

        //工资总和
        Double total = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("******* " + total);

        //最大工资的人
        Optional<Employee> employee = employees.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(),e2.getSalary())));
        System.out.println("******* " + employee.get().getSalary());

        //最小工资
        Optional<Double> minSalary = employees.stream().map(Employee::getSalary).collect(Collectors.minBy((s1,s2) -> Double.compare(s1,s2)));
        System.out.println("******* " + minSalary.get());
    }

    @Test
    public void test3() {
        //按照 员工状态 分组,把同一种状态的员工放入集合中
        Map<Employee.Status,List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println("******* " + map);
    }

    /**
     * 多级分组
     * 先按 状态分组
     * 再在上面的组内按照 年龄分
     */
    @Test
    public void test4() {
        Map<Employee.Status,Map<String,List<Employee>>> map =
        employees.stream().collect(Collectors.groupingBy(Employee::getStatus,Collectors.groupingBy((Employee e) -> {
            if (e.getAge() <= 35){
                return "青年";
            }else if (e.getAge() <= 50) {
                return "中年";
            }else {
                return "老年";
            }
        })));

        System.out.println("******* " + map);
    }


    /**
     * 分区、分片
     */
    @Test
    public void test5() {
        //工资大于8000的在一个集合， 工资小于8000的在一个集合
        Map<Boolean,List<Employee>> map = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 8000));
        System.out.println("*******" + map);
    }

    /**
     * summarizingDouble
     * 汇总，各个的统计都有
     */
    @Test
    public void test6() {
        DoubleSummaryStatistics dss = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("******* " + dss);
    }

    /**
     * 连接字符串
     */
    @Test
    public void test7() {
        String na = employees.stream().map(Employee::getName).collect(Collectors.joining());
        System.out.println("******* " + na);

        String na2 = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println("******* " + na2);

        String na3 = employees.stream().map(Employee::getName).collect(Collectors.joining(",","[","]"));
        System.out.println("******* " + na3);
    }






}
