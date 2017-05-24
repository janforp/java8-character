package com.janita.base.mook.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janita on 2017-05-24 14:47
 * 数据流可以是连续的或平行的。
 * 在一个单独的线程上进行操作，
 * 同时在多个线程上执行并行操作。
 * 下面的例子演示了如何使用并行流很容易的提高性能
 */
public class ParallelStreamsTest {

    private List<String> values = null ;

    @Before
    public void init() {
        int max = 1000000;
        values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
    }

    /**
     * 流对这个集合进行排序消耗的时间
     */
    @Test
    public void testSequentialSort() {
        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        //parallel sort took: 720 ms
    }

    /**
     * 你可以看到这两段代码片段几乎是相同的，
     * 但并行排序大致是50%的差距。
     * 唯一的不同就是把stream()改成了parallelStream()
     */
    @Test
    public void testParallelSort() {
        long t0 = System.nanoTime();

        long count = values.parallelStream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));

        //parallel sort took: 420 ms
    }
}
