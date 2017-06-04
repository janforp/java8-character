package com.janita.book.chapter8.responsibility_chain;

/**
 * Created by Janita on 2017/6/4- 12:50
 * 把两个处理对象结合起来,构造一个操作序列
 */
public class ChainTest {

    public static void main(String[] args) {
        //头部处理
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        //拼写处理
        ProcessingObject<String> p2 = new SpellCheckProcessing();

        p1.setSuccessor(p2);

        String result = p1.handle("Aren`t labdas really sexy?!!");
        System.out.println("\n****************** " + result);
    }
}
