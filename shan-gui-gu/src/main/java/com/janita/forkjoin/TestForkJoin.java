package com.janita.forkjoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * Created by Janita on 2017-05-25 16:38
 * 就是因为写起来比较麻烦
 * 所以用的不是特别广泛
 */
public class TestForkJoin {

    /**
     * ForkJoin框架
     *
     * 4818
     */
    @Test
    public void test1() {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0,10000000000L);
        Long sum = pool.invoke(task);
        System.out.println("******* " + sum);
        Instant end = Instant.now();
        System.out.println("耗费时间 " + Duration.between(start,end).toMillis());
    }

    /**
     * 普通for循环完成上面的计算
     *
     * 47858ms
     */
    @Test
    public void test2() {
        Instant start = Instant.now();
        Long sum = 0L;
        for (long i=0;i<10000000000L ;i++) {
            sum += i;
        }
        System.out.println("******* " + sum);
        Instant end = Instant.now();
        System.out.println("耗费时间 " + Duration.between(start,end).toMillis());
    }


    /******************************java8*****************************/

    /**
     * 2615ms
     */
    @Test
    public void test3() {
        Instant start = Instant.now();
        //切换为并行流
        LongStream.rangeClosed(0,10000000000L).parallel().reduce(0,Long :: sum);
        Instant end = Instant.now();
        System.out.println("耗费时间 " + Duration.between(start,end).toMillis());
    }
}
