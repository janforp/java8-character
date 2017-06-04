package com.janita.book.chapter8.observer;

/**
 * Created by Janita on 2017/6/4- 12:16
 */
public class NYTimes implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}
