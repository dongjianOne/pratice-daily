package com.dong.thread;

/**
 * @Author DongJian
 * @Date Created in 2020/3/26 22:17
 * Utils: Intellij Idea
 * @Description: create Thread by Runnable interface
 * @Version:1.0
 */
public class TestRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我在学习多线程"+i);
        }
    }

    public static void main(String[] args) {
        // 创建Runnable接口的实现类对象
        TestRunnable tr = new TestRunnable();
        // 创建线程对象，通过线程对象开启线程
        new Thread(tr).start();
        for (int i = 0; i < 300; i++) {
            System.out.println("我在看代码："+i);
        }
    }
}
