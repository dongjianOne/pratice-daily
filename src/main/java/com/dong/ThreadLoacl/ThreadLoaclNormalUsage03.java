package com.dong.ThreadLoacl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author DongJian
 * @date Created in 2020/11/26 9:36
 * Utils: Intellij Idea
 * @description: 使用ThreadLocal为每个线程提供单独的对象，避免共享一个对象和线程安全问题
 * @version:1.0
 */
public class ThreadLoaclNormalUsage03 {

    // 线程池
    static ExecutorService threadPool = new ThreadPoolExecutor(50, 100, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2));


    public static void main(String[] args) throws InterruptedException {
        // 开辟线程
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String date1 = new ThreadLoaclNormalUsage03().date(finalI);
                    System.out.println("date1:" + date1);
                }
            });
        }
        threadPool.shutdown();
    }

    public String date(int secounds) {
        Date date = new Date(1000 * secounds);
        SimpleDateFormat dateFormat = ThreadLoaclSimpler.dateFormatThreadLocal.get();
        return dateFormat.format(date);
    }
// 静态内部类
static class ThreadLoaclSimpler {
        // 匿名内部类
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };


}
}
