package com.janita.book.chapter8.observer;

/**
 * Created by Janita on 2017/6/4- 12:19
 */
public class Guardian implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another news in London! " + tweet);
        }
    }
}
