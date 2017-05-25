package com.janita.stream;

import com.janita.bean.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Janita on 2017-05-25 13:38
 *
 * 归约
 * reduce(T identity, BinaryOperator) / reduce(BinaryOperator)
 * -- 可以将流中的原始反复结合起来， 得到一个值
 */
public class TestStreamAPIReduce {

    private List<Employee> employees = Employee.employeeList();

    /**
     * 求和的步骤/原理：
     * 1.首先把起始值作为x,从流中取第一个作为y;
     * 2.执行函数 x + y 得到一个值
     * 3.把上面得到的 x + y 作为第二次运算的 x， 从流中取第二个作为y;
     * 4.重复第二步的操作......
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //计算总和， 其实第一个参数就是 起始值，返回的结果肯定不会为空
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println("******* " + sum);

        System.out.println("******************************************");

        //为什么这里返回的是 Optional 呢？ 因为，这里没有起始值，上面的有起始值，他肯定不为空
        Optional<Double> totalSalary = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println("******* " + totalSalary.get());
    }
}
