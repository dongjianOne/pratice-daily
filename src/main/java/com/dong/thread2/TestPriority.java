package com.dong.thread2;

import lombok.SneakyThrows;

/**
 * @Author DongJian
 * @Date Created in 2020/4/11 21:42
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class TestPriority {
    public static void main(String[] args) {
        //输出主线程优先级
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        // 设置线程优先级
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        t2.setPriority(4);
        t2.start();

        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();

        t4.setPriority(8);
        t4.start();
    }
}

class MyPriority implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
    }
}