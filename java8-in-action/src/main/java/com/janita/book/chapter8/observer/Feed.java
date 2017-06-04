package com.janita.book.chapter8.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janita on 2017/6/4- 12:23
 */
public class Feed implements  Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {

        this.observers.add(observer);
    }

    @Override
    public void notifyObservers(String tweet) {

        observers.forEach(o -> o.notify(tweet));
    }


    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());
        feed.registerObserver(new LeMonde());

        feed.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }
}
