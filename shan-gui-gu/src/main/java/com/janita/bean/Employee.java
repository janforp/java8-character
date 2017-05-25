package com.janita.bean;

import lombok.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Janita on 2017-05-24 21:54
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String name;

    private Integer age;

    private Double salary;

    public Employee(Integer age) {
        this.age = age;
    }

    public static List<Employee> employeeList() {
        List<Employee> employees = Arrays.asList(
                new Employee("张三",18,9999.99),
                new Employee("李四",38,5555.99),
                new Employee("王五",50,6666.66),
                new Employee("赵六",16,3333.33),
                new Employee("田七",8,8888.88),
                new Employee("田七",8,8888.88),
                new Employee("田七",8,8888.88)
                );
        return employees;
    }
}
