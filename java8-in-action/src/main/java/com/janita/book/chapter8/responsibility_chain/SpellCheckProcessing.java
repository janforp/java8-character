package com.janita.book.chapter8.responsibility_chain;

/**
 * Created by Janita on 2017/6/4- 12:48
 * 文本处理对象
 */
public class SpellCheckProcessing extends  ProcessingObject<String>{

    @Override
    protected String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
