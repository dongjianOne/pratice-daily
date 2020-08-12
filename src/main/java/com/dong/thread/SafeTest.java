package com.dong.thread;

import com.dong.threadsafety.VolatileTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author DongJian
 * @Date Created in 2020/8/11 16:33
 * Utils: Intellij Idea
 * @Description: juc包下的AtoMicXX包装类能保证线程安全
 * @Version:1.0
 */
public class SafeTest {

    public static AtomicInteger count = new AtomicInteger(0);

    public static int times = 10000;
    public static void main(String[] args) {

        long curTime = System.nanoTime();
        // 开启--线程
        Thread decThread = new DecThread();
        decThread.start();

        // ++操作
        System.out.println("start main thread" + Thread.currentThread() + "i++");

        for (int i = 0; i < times; i++) {
            // ++
            count.incrementAndGet();
        }
        System.out.println("end main thread" + Thread.currentThread() + "i++");
        // 等待线程结束
        while (decThread.isAlive()) ;

        long endTime = System.nanoTime() - curTime;
        System.out.println("Result:" + count);
    }

    private static class DecThread extends Thread {
        @Override
        public void run() {
            System.out.println("thread start" + Thread.currentThread() + "i--");
            for (int i = 0; i < times; i++) {
                // --操作
                count.decrementAndGet();
            }
            System.out.println("thread end" + Thread.currentThread() + "i--");
        }
    }
}
