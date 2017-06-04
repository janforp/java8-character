package com.janita.book.chapter8.observer.newobserver;

import com.janita.book.chapter8.observer.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janita on 2017/6/4- 12:23
 */
public class NewFeed implements  Subject {

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

        NewFeed feed = new NewFeed();

        feed.registerObserver((String tweet) -> {

            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });

        feed.registerObserver((String tweet) -> {

            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London! " + tweet);
            }
        });

        feed.registerObserver((String tweet) -> {

            if (tweet != null && tweet.contains("wine")) {
                System.out.println("Today cheese, wine and news! " + tweet);
            }
        });

        feed.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }
}
