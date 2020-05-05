package com.dong.thread2;

/**
 * @Author DongJian
 * @Date Created in 2020/3/29 23:42
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class TestYield {
    public static void main(String[] args) {
        new Thread(new Yield(),"a").start();
        new Thread(new Yield(),"b").start();
    }
}
class Yield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"：开始执行");
        // 线程礼让(暂停当前执行的线程，释放cpu资源，再重新竞争资源）线程礼让不一定成功
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"：执行完毕了");
    }
}