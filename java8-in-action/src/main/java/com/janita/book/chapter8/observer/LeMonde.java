package com.janita.book.chapter8.observer;

/**
 * Created by Janita on 2017/6/4- 12:20
 */
public class LeMonde implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("wine")) {
            System.out.println("Today cheese, wine and news! " + tweet);
        }
    }
}
