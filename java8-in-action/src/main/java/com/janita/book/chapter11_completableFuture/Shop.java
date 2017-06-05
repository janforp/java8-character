package com.janita.book.chapter11_completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by Janita on 2017/6/5 0005- 上午 9:33
 * 该类是：
 */
public class Shop {

    private String product;
    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Shop() {
    }

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * 异步
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
           try {
               double price = calculatePrice(product);
               futurePrice.complete(price);
           }catch (Exception ex) {
               //把异步线程中的异常封装起来，让调用者可以知道原因
               futurePrice.completeExceptionally(ex);
           }
        }).start();
        return futurePrice;
    }

    /**
     * 使用工厂方法
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    /**
     * 同步
     * @param product
     * @return
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        Utils.delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static List<Shop> shopList() {
        return Arrays.asList(new Shop("BestShop"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));
    }


}
