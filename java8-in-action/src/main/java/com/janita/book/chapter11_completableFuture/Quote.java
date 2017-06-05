package com.janita.book.chapter11_completableFuture;

/**
 * Created by Janita on 2017/6/5 0005- 下午 2:07
 * 该类是：
 */
public class Quote {

    private final String shopName;
    private final double price;
    private final Discount.Code discountCode;

    public Quote(String shopName, double price, Discount.Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    /**
     * 由商店的返回值解析为quote对象
     * @param s
     * @return
     */
    public static Quote parse(String s) {
        String[] spilt = s.split(":");
        String shopName = spilt[0];
        double price = Double.parseDouble(spilt[1]);
        Discount.Code code = Discount.Code.valueOf(spilt[2]);

        return new Quote(shopName, price, code);
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}
