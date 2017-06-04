package com.janita.book.chapter8.observer;

/**
 * Created by Janita on 2017/6/4
 */
@FunctionalInterface
public interface Observer {

    void notify(String tweet);
}
