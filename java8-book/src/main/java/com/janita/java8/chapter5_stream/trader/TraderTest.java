package com.janita.java8.chapter5_stream.trader;

import org.junit.Test;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * Created by Janita on 2017-06-01 20:23
 */
public class TraderTest {

    @Test
    public void test1() {
        Transaction.transactionList().stream().filter(transaction -> transaction.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void test2() {
        Transaction.transactionList().stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void test3 () {
        Transaction.transactionList().stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(comparing(Trader::getName))
                .forEach(System.out::println);
    }

    @Test
    public void test4() {
        Transaction.transactionList().stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void test5 () {
        Boolean b = Transaction.transactionList()
                .stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        System.out.println("********  " +  b);
    }

    @Test
    public void test6 () {
        Integer sum = Transaction.transactionList()
                .stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(0,(x,y) -> x + y );

        System.out.println("********  " +  sum);
    }

    @Test
    public void test7 () {

        Optional<Integer> max = Transaction.transactionList()
                .stream()
                .map(Transaction::getValue)
                .max(Integer::max);

        System.out.println("********  " +  max.get());
    }

    @Test
    public void test8() {

        Optional<Transaction> optional = Transaction.transactionList()
                .stream()
//                .collect(Collectors.minBy((t1,t2) -> (t1.getValue() - t2.getValue())));
        .min(comparing(Transaction::getValue));

        System.out.println("********  " +  optional.get());
    }

    @Test
    public void test9 () {

        Integer sum = Transaction.transactionList()
                .stream()
                .mapToInt(Transaction::getValue)
                .sum();

        System.out.println("********  " +  sum);
    }

    @Test
    public void test10 () {

         Transaction.transactionList()
                .stream()
                .mapToInt(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println("********  " );

        Transaction.transactionList()
                .stream()
                .mapToInt(Transaction::getValue)
                .sequential()
                .forEach(System.out::println);
    }

    @Test
    public void test11 () {
//        IntStream stream = IntStream.range(1,10);
//        stream.forEach(System.out::println);
//
//        stream = IntStream.rangeClosed(1,10);
//        stream.forEach(System.out::println);

        System.out.println("********  " +  (Math.sqrt(45) % 1 == 0));
    }

    @Test
    public void test12 () {
        Stream<int[]> stream =
            IntStream.rangeClosed(1,100)
                    .boxed()
                    .flatMap(a -> IntStream.rangeClosed(a, 100)
                    .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                    .mapToObj(b -> new int[]{a,b,(int)Math.sqrt(a*a + b*b)}));

        stream.limit(5)
                .forEach(t -> System.out.println(t[0] + " " + t[1] + " " + t[2]));

        System.out.println("********  " );

                IntStream.rangeClosed(1,100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a,100)
                        //因为 mapToObj 返回的是一个流
                .mapToObj(b -> new double[]{a,b,Math.sqrt(a*a+b*b)})
                .filter(t -> t[2] % 1 == 0));

    }
}
