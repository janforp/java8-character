package com.janita.book.chapter8.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by Janita on 2017/6/4- 13:15
 * 该类是:新版的工厂方法模式
 */
public class NewFactory {

    final static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProduct(String name){

        Supplier<Product> productSupplier = map.get(name);
        if (productSupplier != null) return productSupplier.get();
        throw new IllegalArgumentException("没有改产品" + name);
    }
}
