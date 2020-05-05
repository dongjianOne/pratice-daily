package com.dong.thread;

/**
 * @Author DongJian
 * @Date Created in 2020/3/26 20:47
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class ThreadDemo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程"+i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("我在看代码:"+i);
        }
    }
}

