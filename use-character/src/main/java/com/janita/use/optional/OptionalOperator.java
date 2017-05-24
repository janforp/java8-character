package com.janita.use.optional;

import com.janita.use.bean.Book;
import com.janita.use.exception.BookNotFoundException;
import com.janita.use.utils.UseUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * Created by Janita on 2017-05-24 17:44
 */
public class OptionalOperator {

    List<Book> bookList = null ;

    @Before
    public void init() {
        bookList = UseUtils.getBookList();
    }

    /**
     * 从 book 表中
     * 找到 书名为 title 的书
     * 返回结果可能是 null 也可能是 一个对象
     */
    @Test
    public void findBookByTitle() {

        Optional<Book> foundBook = bookList.stream()
                .filter(book -> book.getTitle().equals("寻秦记2"))
                .findFirst();

        //可以抛出自定义异常
        foundBook.orElseThrow(() -> new BookNotFoundException("没有名字为"  + "寻秦记2的书"));
    }
}
