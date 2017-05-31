package com.janita.java8.chapter2.assit;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Janita on 2017-05-30 10:23
 */
public class Apple {

    private String color;

    private double weight;

    private String country;

    public String getColor() {
        return color;
    }

    public Apple(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public Apple(String color, double weight, String country) {
        this.color = color;
        this.weight = weight;
        this.country = country;
    }

    public Apple() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", country='" + country + '\'' +
                '}';
    }


    public static List<Apple> appleList() {

        List<Apple> inventory = Arrays.asList(new Apple("green",80, "china"),
                new Apple("green", 80, "american"),
                new Apple("red", 120 , "brt"));

        return inventory;
    }
}
