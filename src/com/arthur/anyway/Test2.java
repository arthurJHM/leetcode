package com.arthur.anyway;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @program: leetcode
 * @description: 测试longStream
 * @title: Test2
 * @Author hengmingji
 * @Date: 2021/10/21 18:30
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            wrong();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static ConcurrentHashMap<String, Long> getData(int count) {
        return LongStream.rangeClosed(1, count)
                .boxed()
                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(), Function.identity(),
                        (o, o2) -> o, ConcurrentHashMap::new));
    }

    public static String wrong() throws InterruptedException {
        ConcurrentHashMap<String, Long> data = getData(900);
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1,10).parallel().forEach(i -> {
            System.out.println("test");
            System.out.println(Thread.currentThread().getName());
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        return "OK";
    }
}
