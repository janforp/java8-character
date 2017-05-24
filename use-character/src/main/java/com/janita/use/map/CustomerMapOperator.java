package com.janita.use.map;

import com.janita.use.bean.Customer;
import com.janita.use.utils.UseUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Janita on 2017-05-24 16:58
 * 对 客户 集合的操作
 */
public class CustomerMapOperator {

    Map<Long,Customer> customerMap = null ;

    @Before
    public void initMap() {
        customerMap = UseUtils.getCustomerMap();
    }

    /**
     * 检查某个成员在 map 中是否存在，若不存在则添加之
     */
    @Test
    public void operateCustomerList() {

        Customer customer = new Customer();
        customer.setCustomerId(3L);
        customer.setAddress("湖北");
        customer.setCustomName("张三");
        customer.setGender(1);

        Long customerId = customer.getCustomerId();

        //如果这个客户之前不在map中，则把他加入map，若之前已经在了，则不操作
        customerMap.computeIfAbsent(customerId, id -> customer);

        Customer customerOther = customerMap.get(3L);
        System.out.println("*******" + customerOther.getCustomName());
    }

    /**
     * 方法引用
     */
    @Test
    public void methodReference() {

        Customer customer = new Customer();
        customer.setCustomerId(4L);
        customer.setAddress("湖北");
        customer.setCustomName("张三");
        customer.setGender(1);
        //TODO 报错
//        customerMap.computeIfAbsent(customer.getCustomerId(), Customer :: new);
    }
}
