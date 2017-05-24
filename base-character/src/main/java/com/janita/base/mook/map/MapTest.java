package com.janita.base.mook.map;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Janita on 2017-05-24 14:58
 * 正如前面所说的Map不支持流操作，
 * 现在的Map支持各种新的实用的方法和常见的任务
 */
public class MapTest {

    Map<Integer, String> map = null;

    @Before
    public void init() {
        map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "VAL" + i);
        }
    }

    @Test
    public void testMapForEach() {
        //遍历
        map.forEach((key, value) -> System.out.println(value));
    }

    /**
     *  如果map中有这个key才进行后面的计算，
     *  如果没有，则不进行
     */
    @Test
    public void computeIfPresent() {

        map.computeIfPresent(3, (key, val) -> val + key);
        String result = map.get(3);
        System.out.println("*******" + result);

        map.computeIfPresent(100, (key, val) -> val + key);
        String result2 = map.get(100);
        System.out.println("*******" + result2);
    }

    /**
     * 如果map中没有此key，则添加
     */
    @Test
    public void computeIfAbsent() {
        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);    // true
        String result = map.get(23);
        System.out.println("*******" + result);

        //此key之前已经存在了，所以在此不会进行后面的计算
        map.computeIfAbsent(3, num -> "bam");
        String rest3 = map.get(3);
        System.out.println("*******"+rest3);
    }

    /**
     * 删除map元素
     */
    @Test
    public void remove() {
        map.remove(4, "val4");
        System.out.println("*******" + map.get(4));

        map.remove(4, "VAL4");
        System.out.println("*******" + map.get(4));
    }


    @Test
    public void getOrDefault() {
        System.out.println("*******" + map.getOrDefault(200,"NOT FOUND"));
    }

    @Test
    public void merge() {
        map.put(9,"VAL9");
        map.merge(666, "VAL9", (value, newValue) -> value.concat(newValue));
        System.out.println("*******" +  map.get(9)) ;
    }

    @Test
    public void test(){
        System.out.println("VAL9".concat("VAL9"));
    }

}
