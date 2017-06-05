package com.janita.book.chapter11_completableFuture;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Created by Janita on 2017/6/5 0005- 下午 2:05
 * 该类是：
 */
public class ShopTest {

    private final Executor executor =
            Executors.newFixedThreadPool(Math.min(Shop.shopList().size(), 100),
                    r -> {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        return t;
                    });



    /**
     * 获取价格的第一个方法
     * @param product
     * @return
     */
    public List<String> findPricesOne(String product) {
        return Shop.shopList()
                .parallelStream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    @Test
    public void test1() {
        long start = System.nanoTime();

        List<String> prices = findPricesOne("商品");

        prices.forEach(price -> System.out.println("\n*** " + price));

        long end = System.nanoTime();
        System.out.println("\n****** 消耗时间 : " + (end - start) / 1_000_000 );

    }


    /**
     * 获取价格的第二个方法
     * @param product
     * @return
     */
    public List<String> findPricesTwo(String product) {

        List<CompletableFuture<String>> priceFutures =
                Shop.shopList()
                .stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                .collect(Collectors.toList());

        return priceFutures
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    @Test
    public void test2() {
        long start = System.nanoTime();

        List<String> prices = findPricesTwo("商品");

        prices.forEach(price -> System.out.println("\n*** " + price));

        long end = System.nanoTime();
        System.out.println("\n****** 消耗时间 : " + (end - start) / 1_000_000 );
    }
}
