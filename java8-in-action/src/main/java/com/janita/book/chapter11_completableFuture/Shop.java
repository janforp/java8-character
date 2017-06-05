package com.janita.book.chapter11_completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void randomDelay() {
        int delay = 500 + new Random().nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    private double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static List<Shop> shopList() {
        return Arrays.asList(new Shop("BestShop"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"),
                new Shop("Janita`Shop"));
    }

    public String getPrice(String product) {
        //等待1秒
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)];

        return String.format("%s:%.2f:%s", shopName, price, code);
    }
}
