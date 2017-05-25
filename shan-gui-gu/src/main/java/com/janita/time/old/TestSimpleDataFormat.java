package com.janita.time.old;

import com.janita.time.old.DataFormatThreadLocal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Janita on 2017-05-25 17:57
 */
public class TestSimpleDataFormat {

    public static void main(String[] args) throws Exception{

        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return DataFormatThreadLocal.convert("20161218");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }

        for (Future<Date> future :results) {
            System.out.println("******* "+ future.get());
        }

        pool.shutdown();
    }
}
