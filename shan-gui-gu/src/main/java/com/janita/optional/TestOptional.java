package com.janita.optional;

import com.janita.bean.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by Janita on 2017-05-25 16:57
 *
 * 一、Optional 容器类：用于尽量避免空指针异常
 * 	Optional.of(T t) : 创建一个 Optional 实例
 * 	Optional.empty() : 创建一个空的 Optional 实例
 * 	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * 	isPresent() : 判断是否包含值
 * 	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 * 	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * 	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * 	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class TestOptional {

    @Test
    public void test1() {
        Optional<Employee> optional = Optional.of(null);
        if (optional.isPresent()){
            Employee employee = optional.get();
            System.out.println("******* " + employee);
        }
    }

    @Test
    public void test2() {
        Optional<Employee> optional = Optional.empty();
        System.out.println("******* " + optional.get());
    }

    @Test
    public void test3() {
        Optional<Employee> optional = Optional.ofNullable(new Employee());
        System.out.println("******* "+ optional.get());

        Optional<Employee> optional2 = Optional.ofNullable(null);
        System.out.println("******* "+ optional2.get());
    }

    @Test
    public void test4() {
        Optional<Employee> optional = Optional.ofNullable(null);
        optional.ifPresent(employee -> System.out.println("******* " + employee));
    }

    @Test
    public void test5() {
        Optional<Employee> optional = Optional.ofNullable(null);
//        Employee employee = optional.orElse(new Employee("默认值",18,18.0, Employee.Status.BUSY));
//        System.out.println("******* "+ employee);

        Employee employee = optional.orElseGet(Employee::new);
        System.out.println("******* "+ employee);
    }

    @Test
    public void test6() {
        Optional<Employee> optional = Optional.ofNullable(new Employee("默认值",18,18.0, Employee.Status.BUSY));

        Optional<String> str = optional.map(Employee::getName);

        System.out.println("******* "+ str.get());

        Optional<String> str2 = optional.flatMap((e) -> Optional.of(e.getName()));
        System.out.println("******* "+ str2.get());
    }
}
