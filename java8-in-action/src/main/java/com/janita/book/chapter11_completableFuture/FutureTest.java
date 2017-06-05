package com.janita.book.chapter11_completableFuture;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Created by Janita on 2017/6/5 0005
 */
public class FutureTest {

    public static void future1() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(FutureTest::doSomethingInOtherThread);
        doSomethingElse();
        try {
            Double result = future.get(1, TimeUnit.SECONDS);
            System.out.println("****** 第一个任务的结果是：  " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void doSomethingElse(){
        System.out.println("******  后面的任务完成了");
    }

    private static Double doSomethingInOtherThread() throws InterruptedException {
        Thread.sleep(500);
        return 20.0;
    }

    public static void main(String[] args) throws InterruptedException {
//        future2();
    }



    public static void future2() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("****** 异步方法调用消耗时间 :  " + invocationTime + " msecs");

        doSomethingElse();

        try {
            double price = futurePrice.get();
            System.out.println("****** 返回的价格是 : " + price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("\n******返回价格消耗时间 :  " + retrievalTime + " msecs");
    }


    /**
     * 顺序执行
     */
    @Test
    public void test() {
        long start = System.currentTimeMillis();
        Shop.shopList().stream()
                .map(shop -> {
                    try {
                        return String.format("%s price is %.2f", shop.getShopName(), shop.getPriceAsync("product").get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).forEach(System.out::println);
        long end = System.currentTimeMillis();

        System.out.println("\n****** 消耗时间 : " + (end - start));
    }



}
