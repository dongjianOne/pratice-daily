package com.dong.test;

import com.dong.utils.CombinationParamsUtilsByDJ;

import java.util.HashMap;
import java.util.Map;


public class MapTest {

    static Integer ITEM_COUNT = 10;

    public static void main(String[] args) {
        /*ConcurrentHashMap<String, Long> concurrentHashMap = new ConcurrentHashMap<>(ITEM_COUNT);
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
    */

        Map<String, Object> params = new HashMap<>(16);
        params.put("name", "jude");
        params.put("action", "select");
        String url = CombinationParamsUtilsByDJ.mappingToQueryParams(params, CombinationParamsUtilsByDJ.SortedInfo.KEY_DESC);
        System.out.println(url);
    }
}
