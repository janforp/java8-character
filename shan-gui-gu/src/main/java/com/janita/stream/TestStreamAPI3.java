package com.janita.stream;

import com.janita.bean.Employee;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by Janita on 2017-05-25 12:47
 * 终止操作
 *
 * 查找与匹配
 * allMatch -- 检查是否匹配所有元素
 * anyMatch -- 检查是否至少一个匹配
 * noneMatch -- 检查是否没有匹配的原始
 *
 * findFirst -- 返回第一个元素
 * findAny -- 返回当前流中的任意元素
 *
 * count -- 返回当前流中的元素的总个数
 *
 * max -- 返回流中的最大值
 * min -- 返回流中的最小值
 *
 */
public class TestStreamAPI3 {

    private List<Employee> employees = Employee.employeeList();

    @Test
    public void test1(){
        boolean s = employees.stream()
                .allMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println("******* " + s);

        boolean s2 = employees.stream()
                .anyMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println("******* " +s2);

        boolean s3 = employees.stream()
                .noneMatch(e -> e.getSalary().equals(Employee.Status.BUSY));
        System.out.println("******* " + s3);

        //Optional，因为有可能为空
        Optional<Employee> op = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).findFirst();

        System.out.println("******* " + op.get());

        //得到一个空闲的人
        Optional<Employee> free = employees.parallelStream().filter(e -> e.getStatus().equals(Employee.Status.FREE)).findAny();
        System.out.println("******* " + free.get());
    }

    @Test
    public void test2() {
        Long size = employees.stream().count();
        System.out.println("******* " + size);

        Optional<Employee> employee = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("******* " + employee.get());

        Optional<Double> salary = employees.stream().map(Employee :: getSalary).min(Double::compare);
        System.out.println("******* " + salary.get());
    }


}
