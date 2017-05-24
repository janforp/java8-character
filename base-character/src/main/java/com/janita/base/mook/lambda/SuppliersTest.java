package com.janita.base.mook.lambda;

import com.janita.base.bean.Person;
import org.junit.Test;

import java.util.function.Supplier;

/**
 * Created by Janita on 2017-05-24 12:47
 * Suppliers产生一个给定的泛型类型的结果。
 * 与Functional不同的是Suppliers不接受输入参数。
 */
public class SuppliersTest {

    @Test
    public void testSuppliers() {
        Supplier<Person> personSupplier = Person::new;
        Person per = personSupplier.get();   // new Person
        System.out.println("*******"+per);
    }
}
