package com.janita.book.chapter8.responsibility_chain;

/**
 * Created by Janita on 2017/6/4- 12:45
 * 文本处理对象
 */
public class HeaderTextProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String input) {
        return "From Raoul, Mario and Alan: " + input;
    }
}
