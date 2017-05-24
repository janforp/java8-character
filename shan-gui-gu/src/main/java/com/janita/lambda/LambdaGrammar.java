package com.janita.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Created by Janita on 2017-05-24 22:26
 * java8中引入的新的操作符 "->"
 * 箭头操作符或Lambda操作符
 *
 * 左侧: Lambda 表达式的参数列表
 * 右侧: Lambda 表示大中所需要执行的功能,即 Lambda 体
 *
 * 其实 Lambda 表达式就是实现一个函数式接口方法,
 *  "->" 左侧就是该接口方法的参数, "->" 右侧就是对该接口方法的具体实现
 *
 *  这些语法格式的不同其实就是根据接口方法的不同而出现的
 *  语法格式一:  接口方法 无参数,无返回值
 *      () -> 实现功能的语句,如 System.out.println("呵呵呵呵)
 *
 *  语法格式二: 接口方法  有一个参数, 无返回值 void doSht(T t)
 *      (x) -> System.out.println(x)
 *
 *  语法格式三: 若接口方法只有一个参数,则左侧的小括号可以不写
 *
 *  语法格式四: 接口方法 有两个以上参数, 并且 Lambda 体中有多条语句, 且有返回值
 *       Comparator<Integer> com = (x, y) -> {
 *          System.out.println("强行加上一句,测试有多条语句");
 *          return x - y;
 *
 *   语法格式五: 接口方法 有两个以上参数, 并且 Lambda 体中只有一条语句, 且有返回值
 *           public void grammar5() {
 *              Comparator<Integer> com = (x, y) -> x - y;
 *            }
 *
 *    语法格式六: Lambda 表达式的参数列表的数据类型可以省略不写, 因为JVM编译器可以
 *    通过上下文推断出数据类型,成为 "类型推断"
 };
 *
 *
 */
public class LambdaGrammar {

    /**
     *  语法格式一:  接口方法 无参数,无返回值
     *      () -> 实现功能的语句,如 System.out.println("呵呵呵呵)
     */
    @Test
    public void grammar1() {
        //实际上还是 final
        int num = 100 ;

        Runnable runnable = () -> System.out.println("Hello Lambda  " + num);
        runnable.run();
    }


    /**
     * 语法格式二: 接口方法  有一个参数, 无返回值 void doSht(T t)
     */
    @Test
    public void grammar2() {

        //其实就是 (x) -> System.out.println(x)
        Consumer<String> con = System.out::println;
        con.accept("打印吧");
    }

    /**
     * 语法格式四: 接口方法 有两个以上参数, 并且 Lambda 体中有多条语句, 且有返回值
     */
    @Test
    public void grammar4() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("强行加上一句,测试有多条语句");
            return x - y;
        };
    }

    /**
     * 语法格式五: 接口方法 有两个以上参数, 并且 Lambda 体中只有一条语句, 且有返回值
     */
    @Test
    public void grammar5() {
        Comparator<Integer> com = (x, y) -> x - y;
    }
}
