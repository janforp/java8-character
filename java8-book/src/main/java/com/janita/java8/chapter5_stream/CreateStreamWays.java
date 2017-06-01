package com.janita.java8.chapter5_stream;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Janita on 2017-06-01 21:42
 */
public class CreateStreamWays {

    @Test
    public void test1() {
        Stream<String> stringStream = Stream.of("a", "c");
        stringStream.map(String::toUpperCase)
                .forEach(System.out::println);

        stringStream = Stream.empty();
    }

    @Test
    public void test2 () {
        int[] ints = new int[]{1,2,3,4};
        IntStream stream = Arrays.stream(ints);
        System.out.println("********  " + stream.sum());
    }

    @Test
    public void test3 () throws IOException {
            Stream<String> stringStream = Files.lines(Paths.get("D:\\gitSpace\\team\\java8-character\\java8-book\\src\\main\\resources\\word.txt"), Charset.defaultCharset());

            Long sum = stringStream.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();

            System.out.println("********  " +  sum);
    }

    @Test
    public void test4() {
        Stream.iterate(0, n -> n +2)
                .limit(10)
                .forEach(System.out::println);
    }

    /**
     *
     */
    @Test
    public void test5 () {
        Stream.iterate(new int[]{0,1}, arr -> new int[]{arr[1] , arr[0] + arr[1]})
                .limit(20)
                .forEach(arr -> System.out.println( "(" +  arr[0] + ", " + arr[1] + ")"));
    }

    @Test
    public void test6 () {

        IntSupplier fib = new IntSupplier() {

            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nexValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nexValue;
                return oldPrevious;
            }
        };

        IntStream.generate(fib).limit(20).forEach(System.out::println);
    }
}
