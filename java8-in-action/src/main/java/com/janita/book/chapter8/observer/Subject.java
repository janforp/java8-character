package com.janita.book.chapter8.observer;

/**
 * Created by Janita on 2017/6/4- 12:21
 */
public interface Subject {

    /**
     * 注册观察者
     * @param observer 观察者
     */
    void registerObserver(Observer observer);

    /**
     * 通知观察者
     * @param tweet 内容
     */
    void notifyObservers(String tweet);
}
