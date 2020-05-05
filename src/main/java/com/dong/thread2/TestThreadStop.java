package com.dong.thread2;

/**
 * @Author DongJian
 * @Date Created in 2020/3/29 21:05
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class TestThreadStop implements Runnable {
    // 定义一个标志位
    private volatile boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run Thread " + i++);
        }
        System.out.println(Thread.currentThread().getName() + i);
    }

//    // 线程停止的标志
//    public void stop() {
//        flag = false;
//    }

    public static void main(String[] args) throws InterruptedException {
        TestThreadStop testThreadStop = new TestThreadStop();
        new Thread(testThreadStop).start();
        Thread.sleep(5);
        for (int i = 0; i < 1000; i++) {
            if (i == 900) {
                testThreadStop.flag = false;
                System.out.println("Thread该停止了");
            }
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
