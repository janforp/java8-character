package com.janita.stream.practice;

import com.janita.bean.Trader;
import com.janita.bean.Transaction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Janita on 2017-05-25 15:00
 */
public class TestTracdor {

    private List<Transaction> transactions = Transaction.transactionList();

    /**
     * 1. 找出2011年发生的所有交易， 并按交易额排序（从低到高）
     */
    @Test
    public void test1() {
        List<Transaction> trans = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)   //先把 2011 的交易取出
                .sorted(Comparator.comparingInt(Transaction::getValue)) //排序，要按照交易额
                .collect(Collectors.toList());
        trans.forEach(System.out::println);
    }

    /**
     * 2. 交易员都在哪些不同的城市工作过？
     */
    @Test
    public void test2() {

        List<String> citiesName = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())  //把流转换成字符串
                .distinct() //去重
                .collect(Collectors.toList());  //放进集合中

        citiesName.forEach(System.out::println);
    }

    /**
     * 3. 查找所有来自剑桥的交易员，并按姓名排序
     */
    @Test
    public void test3() {
        List<Trader> traders =
                transactions.stream()
                .map(Transaction::getTrader)    //把流从交易转换为交易员
                .filter(trader -> trader.getCity().equals("Cambridge")) //过滤出来自剑桥的交易员
                .sorted(Comparator.comparing(Trader::getName)) //按交易员的姓名排序
                .distinct() //去重
                .collect(Collectors.toList());  //把得到的交易员放进集合中

        traders.forEach(System.out::println);
    }

    /**
     * 4.返回所有交易员的姓名字符串，按字母顺序排序
     */
    @Test
    public void test4() {

        List<String> list = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())  //得到所有姓名的流
                .sorted(String::compareTo)
                .distinct()
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        String name = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .reduce("",String::concat);

        System.out.println("******* " + name);

        transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .flatMap(TestTracdor::filterCharacter)
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out :: println);

    }

    private static Stream<String> filterCharacter(String str) {
        List<String> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch.toString());
        }
        return list.stream();
    }


    /**
     * 5. 有没有交易员是在米兰工作的？
     */
    @Test
    public void test5() {
        Boolean b = transactions.stream()
                .anyMatch(tr -> tr.getTrader().getCity().equals("Milan") );
        System.out.println("******* " + b);
    }

    /**
     * 6. 打印生活在剑桥的交易员的所有交易额
     */
    @Test
    public void test6() {

        Optional<Integer> value = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")) //先把剑桥的交易员的交易对象全部取出
                .map(Transaction::getValue) //再把他们的交易额放入新流中
                .reduce(Integer::sum);

        System.out.println("******* " + value);
    }

    /**
     * 7. 所有交易中，最高的交易额是多少
     */
    @Test
    public void test7() {
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);

        System.out.println("******* " + max);
    }

    /**
     * 8. 找到交易额最小的交易
     */
    @Test
    public void test8() {
        Optional<Transaction> transaction = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue));
        System.out.println("******* " + transaction);
    }
}
