package com.dong.ThreadLoacl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author DongJian
 * @date Created in 2020/11/26 9:36
 * Utils: Intellij Idea
 * @description:
 * @version:1.0
 */
public class ThreadLoaclNormalUsage02 {

    // 线程池
    static ExecutorService threadPool = new ThreadPoolExecutor(50, 100, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2));

    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // not thread-safe

    public static void main(String[] args) throws InterruptedException {
        // 开辟线程
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String date1 = new ThreadLoaclNormalUsage02().date(finalI);
                    System.out.println("date1:" + date1);
                }
            });
        }
        threadPool.shutdown();
    }

    public String date(int secounds) {
        Date date = new Date(1000 * secounds);
        String s;
        synchronized (ThreadLoaclNormalUsage02.class) { // 加锁
            s = dateFormat.format(date);
        }
        return s;
    }
}
