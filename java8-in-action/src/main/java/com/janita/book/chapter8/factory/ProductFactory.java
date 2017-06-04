package com.janita.book.chapter8.factory;

/**
 * Created by Janita on 2017/6/4- 13:11
 * 该类是:
 */
public class ProductFactory {

    public static Product createProduct(String name) {
        switch (name) {
            case "loan": return new Loan();
            case "stock": return new Stock();
            case "bond": return new Bond();
            default: throw new RuntimeException("没有叫 " + name + "的产品");
        }
    }
}
