package com.dong.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MapTest {

    static Integer ITEM_COUNT = 10;

    public static void main(String[] args) {
        ConcurrentHashMap<String, Long> concurrentHashMap = new ConcurrentHashMap<>(ITEM_COUNT);
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.execute(()-> IntStream.rangeClosed(1,100).parallel().forEach(i -> {
            String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
            synchronized (concurrentHashMap) {
                if (concurrentHashMap.containsKey(key)) {
                    concurrentHashMap.put(key, concurrentHashMap.get(key)+1);
                } else {
                    concurrentHashMap.put(key, 1L);
                }
            }
        }));

        forkJoinPool.shutdown();
        forkJoinPool.awaitQuiescence(1, TimeUnit.HOURS);
    }
}
