package com.janita.lambda;

import com.janita.bean.Employee;
import com.janita.lambda.odlway.MyPredicate;
import org.junit.Test;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by Janita on 2017-05-24 21:48
 */
public class TestLambda {

    @Test
    public void lambda() {
        new TreeSet<>(Integer::compareTo);
    }

    /**
     * @param list
     * @param predicate
     * @return
     */
    private List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> predicate) {
        return list.stream().filter(predicate::test).collect(Collectors.toList());
    }

    /**
     * 策虐模式
     */
    @Test
    public void testEmployee() {
        List<Employee> employees = filterEmployee(Employee.employeeList(), employee -> employee.getAge() >= 35);
        employees.forEach(System.out::println);
        System.out.println("*****************************************");
        employees = filterEmployee(Employee.employeeList(), employee -> employee.getSalary() > 5000);
        employees.forEach(System.out::println);
    }

    //纯lambda实现
    @Test
    public void testPureLambda() {
        Employee.employeeList()
                .stream()
                .filter(e -> e.getSalary() >= 5000)
                .limit(2)
                .forEach(System.out::println);

        Employee.employeeList()
                .stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }


}
