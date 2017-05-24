package com.janita.use.utils;

import com.janita.use.bean.Author;
import com.janita.use.bean.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Janita on 2017-05-24 17:00
 */
public class UseUtils {


    public static Map<Long,Customer> getCustomerMap() {

        Customer customerA = new Customer();
        customerA.setCustomerId(1L);
        customerA.setAddress("杭州");
        customerA.setCustomName("朱建");
        customerA.setGender(1);

        Customer customerB = new Customer();
        customerB.setCustomerId(2L);
        customerB.setAddress("湖南");
        customerB.setCustomName("朱力");
        customerB.setGender(1);

        Customer customerC = new Customer();
        customerC.setCustomerId(3L);
        customerC.setAddress("四川");
        customerC.setCustomName("妹子");
        customerC.setGender(0);

        Map<Long,Customer> customerMap = new HashMap<>();
        customerMap.put(customerA.getCustomerId(),customerA);
        customerMap.put(customerB.getCustomerId(),customerB);
        customerMap.put(customerC.getCustomerId(),customerC);

        return customerMap;

    }

    public static List<Author> getAuthorList() {

        List<Author> authorList = new ArrayList<>();

        Author authorA = new Author();
        authorA.setAuthorId(1L);
        authorA.setAuthorName("金庸");

        Author authorB = new Author();
        authorB.setAuthorId(2L);
        authorB.setAuthorName("黄奕");

        Author authorC = new Author();
        authorC.setAuthorId(3L);
        authorC.setAuthorName("郭敬明");

        Author authorD = new Author();
        authorD.setAuthorId(4L);
        authorD.setAuthorName("金庸");

        authorList.add(authorA);
        authorList.add(authorB);
        authorList.add(authorC);
        authorList.add(authorD);

        return authorList;
    }
}
