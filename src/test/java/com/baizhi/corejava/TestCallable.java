package com.baizhi.corejava;

import java.util.concurrent.*;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Integer sum = 0;
                for (int i = 0; i <= 100; i+=2) {
                    sum += i;
                }
                return sum;
            }
        };

        Callable<Integer> task2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Integer sum = 0;
                for (int i = 1; i <= 100; i+=2) {
                    sum += i;
                }
                return sum;
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(3);

        Future<Integer> result1 = es.submit(task1);
        Future<Integer> result2 = es.submit(task2);

        es.shutdown();
        System.out.println(result1.get() + result2.get());


    }
}
