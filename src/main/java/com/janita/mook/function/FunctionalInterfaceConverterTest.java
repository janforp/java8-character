package com.janita.mook.function;

import com.janita.bean.Something;
import com.janita.functional.Converter;
import org.junit.Test;


public class FunctionalInterfaceConverterTest {

    public static void main(String[] args) {
        simpleUse();
        simpler();
        useSomething();
        testFinal();
        testFinal3();
    }

    /**
     * 直接使用
     */
    public static void simpleUse (){
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123
    }

    /**
     * 上面的例子代码可以进一步简化，利用静态方法引用
     */
    public static void simpler() {
        //Integer类的静态方法 ：  valueOf
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);   // 123
    }

    /**
     * 可以通过::关键字调用引用的方法或构造函数。
     * 上面的示例演示了如何引用静态方法。
     * 但我们也可以参考对象方法
     */
    public static void useSomething() {
        Something something = new Something();
        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("Java");
        System.out.println(converted);    // "J"
    }

    /**
     * 可以从本地外部范围以及实例字段和静态变量中
     * 访问final变量
     */
    @Test
    public static void testFinal() {
        final int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
        String converted = stringConverter.convert(2);     // 3
        System.out.println("*******"+ converted);
    }

    /**
     * 但不同的匿名对象变量num没有被声明为final，
     * 下面的代码也有效
     */
    @Test
    public static void testFinal2() {
        int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
        stringConverter.convert(2);     // 3
    }

    /**
     * 然而num必须是隐含的final常量。以下代码不编译
     */
    @Test
    public static void testFinal3() {
        int num = 1;
//        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
        num = 3;
    }
}
