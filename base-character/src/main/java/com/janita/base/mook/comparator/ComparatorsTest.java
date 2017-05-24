package com.janita.base.mook.comparator;

import com.janita.base.bean.Person;
import org.junit.Test;

import java.util.Comparator;

/**
 * Created by Janita on 2017-05-24 12:51
 */
public class ComparatorsTest {

    @Test
    public void testComparators() {
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        // Comparator<Person> comparator = Comparator.comparing(p -> p.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        int nature = comparator.compare(p1, p2);             // > 0
        int reverse = comparator.reversed().compare(p1, p2);  // < 0

        System.out.println("*******" + nature);
        System.out.println("*******" + reverse);
    }
}
