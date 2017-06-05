package com.janita.book.chapter11_completableFuture;

/**
 * Created by Janita on 2017/6/5 0005- 上午 9:34
 * 该类是：
 */
public class Utils {

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
