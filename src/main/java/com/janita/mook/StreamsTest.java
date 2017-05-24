package com.janita.mook;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janita on 2017-05-24 12:58
 *
 * 一个java.util.Stream代表一个序列的元素在其中的一个或多个可以执行的操作。
 * 流操作是中间或终端。当终端操作返回某一类型的结果时，中间操作返回流，
 * 这样就可以将多个方法调用在一行中。流是一个源产生的，
 * 例如java.util.Collection像列表或设置（不支持map）。
 * 流操作可以被执行的顺序或并行。
 */
public class StreamsTest {

    List<String> stringCollection;

    @Before
    public List<String> get() {
        stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        return stringCollection;
    }

    /**
     * 在Java8中Collections类的功能已经有所增强，
     * 你可用调用Collection.stream()或Collection.parallelStream()。
     */
    @Test
    public void testStreams() {

    }

    /**
     * Filter接受一个predicate来过滤流的所有元素。
     * 这个中间操作能够调用另一个流的操作（Foreach）的结果。
     * ForEach接受一个消费者为每个元素执行过滤流。
     * 它是void，所以我们不能称之为另一个流操作。
     */
    @Test
    public void testFilter() {
        stringCollection
                .stream()
                //能不能对对象进行针对字段的过滤呢？ TODO
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
    }

}
