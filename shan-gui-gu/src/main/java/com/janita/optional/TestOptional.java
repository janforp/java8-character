package com.janita.optional;

import com.janita.bean.Employee;
import com.janita.bean.Goddess;
import com.janita.bean.Man;
import com.janita.bean.NewMan;
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

    /***************************例题*******************************/

    /**
     * 需求：获取一个男人心中女神的名字
     */
    private String getGoddessName(Man man) {
        if (man != null) {
            Goddess goddess = man.getGoddess();
            if (goddess != null) {
                return goddess.getName();
            }
        }
        return "苍老师";
    }

    @Test
    public void test7() {
        Man man = new Man();
        //容易出空指针
        System.out.println("******* "+ getGoddessName(man));
    }

    public String getGoddessName2(Optional<NewMan> newMan) {
         return newMan.orElse(new NewMan()).getGoddess().orElse(new Goddess("波多野结衣")).getName();
    }

    @Test
    public void test8() {
        Optional<Goddess> goddess = Optional.ofNullable(new Goddess("苍老师"));
        Optional<NewMan> optional = Optional.ofNullable(new NewMan(goddess));
        String str = getGoddessName2(optional);
        System.out.println("******* " + str);
    }

    @Test
    public void test82() {
        Optional<Goddess> goddess = Optional.ofNullable(new Goddess());
        Optional<NewMan> optional = Optional.ofNullable(new NewMan(goddess));
        String str = getGoddessName2(optional);
        System.out.println("******* " + str);
    }

    @Test
    public void test83() {
        Optional<Goddess> goddess = Optional.ofNullable(null);
        Optional<NewMan> optional = Optional.ofNullable(new NewMan(goddess));
        String str = getGoddessName2(optional);
        System.out.println("******* " + str);   //波多野结衣
    }

    @Test
    public void test84() {
        Optional<NewMan> optional = Optional.ofNullable(new NewMan(null));
        String str = getGoddessName2(optional);
        System.out.println("******* " + str);   //
    }
    @Test
    public void test85() {
        Optional<NewMan> optional = Optional.ofNullable(null);
        String str = getGoddessName2(optional);
        System.out.println("******* " + str);   //波多野结衣
    }





}
