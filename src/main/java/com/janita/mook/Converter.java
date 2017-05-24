package com.janita.mook;

/**
 * Created by Janita on 2017-05-24 11:32
 * 注解 @FunctionalInterface
 * 当你尝试在接口上添加第二个抽象方法声明时，编译器会注意到这个注释并抛出一个编译器错误
 */
@FunctionalInterface
public interface Converter<F, T> {

    T convert (F from);
}


class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}


class ConverterTest{

    public static void main(String[] args) {
//        simpleUse();
//        simpler();
        useSomething();
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


}
