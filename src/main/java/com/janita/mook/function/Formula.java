package com.janita.mook.function;

/**
 * Created by Janita on 2017-05-24 09:42
 */
public interface Formula {

    double calculate(int a) ;

    /**
     * 利用default关键字使我们能够添加非抽象方法实现的接口。此功能也被称为扩展方法
     * @param a
     * @return
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }

    static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100) ;
            }
        };

        double a = formula.calculate(100);

        double b =formula.sqrt(16);

        System.out.println("*******" + a);
        System.out.println("*******" + b);
    }
}
