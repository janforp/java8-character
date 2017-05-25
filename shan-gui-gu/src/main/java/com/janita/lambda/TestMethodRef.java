package com.janita.lambda;

import com.janita.bean.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 方法引用
 * Created by Janita on 2017-05-25 09:53
 *
 *一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
 * 			  （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
 *
 * 1. 对象的引用 :: 实例方法名
 *
 * 2. 类名 :: 静态方法名
 *
 * 3. 类名 :: 实例方法名
 *
 * 注意：
 * 	 ①Lambda 体中 方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * 	 ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
 *
 * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
 *
 * 1. 类名 :: new
 *
 * 三、数组引用
 *
 * 	类型[] :: new;
 *
 *
 */
@SuppressWarnings("unused")
public class TestMethodRef {


    /**
     * 方法引用所引用的方法的参数列表与返回值类型，
     * 需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
     *
     *  void accept(T t) 与 void println(String x) 参数与返回值一致
     */
    @Test
    public void test1() {

        //方法1
        Consumer<String> con =x -> System.out.println(x);

        //方法2
        PrintStream ps = System.out;
        Consumer<String> consumer = ps::println;

        //方法3
        Consumer<String> con2 = System.out::println;
    }

    @Test
    public void test2() {
        Employee employee = new Employee("JJ",20,50.2);
        //方法引用
        Supplier<String> sup = employee::getName;
        System.out.println("*******" + sup.get());
    }


    /***************************类名 :: 静态方法名************************/

    @Test
    public void test3() {
        //方法1
        Comparator<Integer> com1 = (x,y) -> Integer.compare(x,y);
        //方法2,  类名 :: 静态方法名
        Comparator<Integer> com2 = Integer::compare;
    }



    /***************************类名 :: 实例方法名***************************/

    //比较2个字符串是否一样
    @Test
    public void test4() {
        //方法1
        BiPredicate<String,String> bp = (x,y) -> x.equals(y);

        //方法2,实例方法的引用，使用规则：
        // 若Lambda 的参数列表的第一个参数，是实例方法的调用者，
        // 第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
        BiPredicate<String,String> bp2 = String :: equals;
    }


    /*******************************构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！*****************/


    @Test
    public void test5() {
        //方法1
        Supplier<Employee> sup = () -> new Employee();

        //方法2 构造器引用  类名 :: new
        //函数接口中的方法是无参的，所以调用的是无参构造器
        Supplier<Employee> supplier = Employee::new;
    }


    @Test
    public void test6() {

        //其实 -> 左侧的 x 就是 Function 的第一个参数， 也就是  R apply(T t); 的 T
        Function<Integer, Employee> fun = (x) -> new Employee(x);

        //方法2 ,此时就是调用了一个参数的构造器
        Function<Integer, Employee> function = Employee::new;

        //编译不通过，因为没有两个参数的构造器
//        BiFunction<Integer, Integer, Employee> bf = Employee :: new ;
    }
}
