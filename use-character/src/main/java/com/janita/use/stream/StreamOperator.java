package com.janita.use.stream;

import com.janita.use.bean.Author;
import com.janita.use.utils.UseUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Janita on 2017-05-24 17:22
 */
public class StreamOperator {

    List<Author> authorList = null ;

    @Before
    public void init() {
        authorList = UseUtils.getAuthorList();
    }

    /**
     * 按照字母表的顺序排列作者名称
     * 且不重复
     */
    @Test
    public void rank() {
        List<String> names =authorList
//                .stream()       //把集合转换为stream
                .parallelStream()       //把集合转换为stream
                .map(Author::getAuthorName) //对stream中的每个元素转换类型为string
                .distinct() //对转换为string的stream去重
                .sorted(Comparator.naturalOrder())  //排序
                .collect(Collectors.toList());  //放入集合

        System.out.println("*******" + names);
    }
}
