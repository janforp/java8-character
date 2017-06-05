package com.janita.book.chapter11_completableFuture;

/**
 * Created by Janita on 2017/6/5 0005- 下午 1:43
 * 该类是：
 */
public class Discount {

    private static double apply(double price, Code code) {
        Shop.delay();
        return price * (100 - code.percentage)/100;
    }

    /**
     * 返回打折后的价格语句
     * @param quote
     * @return
     */
    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    public enum Code{

        NONE(0),  SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

}
