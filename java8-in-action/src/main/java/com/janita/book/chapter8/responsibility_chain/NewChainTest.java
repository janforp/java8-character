package com.janita.book.chapter8.responsibility_chain;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by Janita on 2017/6/4- 13:03
 * 该类是:
 */
public class NewChainTest {

    public static void main(String[] args) {
        UnaryOperator<String> header = (String text) -> "From Janita: " + text;

        UnaryOperator<String> spell = (String text) -> text.replaceAll("labdas", "λ");

        Function<String,String> pipeline = header.andThen(spell);

        String result = pipeline.apply("Aren`t labdas really sexy?!!");

        System.out.println("\n****************** " + result);
    }
}
