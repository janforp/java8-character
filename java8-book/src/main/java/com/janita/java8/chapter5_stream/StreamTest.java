package com.janita.java8.chapter5_stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Janita on 2017-05-31 21:50
 */
public class StreamTest {

    List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    @Test
    public void test1() {
        List<Integer> num1 = Arrays.asList(1,2,3);
        List<Integer> num2 = Arrays.asList(3,4);

        List<int[]> pairs = num1.stream()
                .flatMap(i -> num2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i,j})).collect(Collectors.toList());

        for (int[] arr : pairs) {
            System.out.println(arr[0] +"  " + arr[1]);
        }

    }

    @Test
    public void test2() {

        nums.stream()
                .filter(i -> i>10)
                .findAny()
                .ifPresent(System.out::println);
    }

    @Test
    public void test3() {

        nums.stream()
                .filter(i -> i*i%3==0)
                .findFirst()
                .ifPresent(System.out::println);
    }

    @Test
    public void test4(){
        Integer sum = nums.stream()
                .reduce(Integer::max).get();

        System.out.println("********  " + sum);
    }

    @Test
    public void test5() {

        Integer sum = nums.stream()
                .reduce(Integer::min).get();

        System.out.println("********  " +  sum);
    }

    @Test
    public void test6 () {

        Optional<Integer> total = nums.stream()
                .map(i -> 1).reduce(Integer::sum);

        System.out.println("********  " +  total.get());
    }


}
