package com.dong.threadsafety;

/**
 * @Author DongJian
 * @Date Created in 2020/8/11 16:07
 * Utils: Intellij Idea
 * @Description: volatile--test i++/-- 是否是线程安全
 * volatile只能保证线程的可见性不能保证线程的原子性
 * @Version:1.0
 */
public class VolatileTest {

    public static int times = 10000;
    // volatile修饰
    public static volatile int count = 0;

    public static void main(String[] args) {

        long curTime = System.nanoTime();
        // 开启--线程
        Thread decThread = new DecThread();
        decThread.start();

        // ++操作
        System.out.println("start main thread" + Thread.currentThread() + "i++");

        for (int i = 0; i < times; i++) {
            count++;
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
                count--;
            }
            System.out.println("thread end" + Thread.currentThread() + "i--");
        }
    }
}
