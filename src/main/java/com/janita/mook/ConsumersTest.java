package com.janita.mook;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * Created by Janita on 2017-05-24 12:49
 * Consumers代表在一个单一的输入参数上执行操作。
 */
public class ConsumersTest {

    @Test
    public void testConsumers() {
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Jan", "Skywalker"));
    }
}
