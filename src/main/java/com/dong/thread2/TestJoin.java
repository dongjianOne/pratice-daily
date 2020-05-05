package com.dong.thread2;

/**
 * @Author DongJian
 * @Date Created in 2020/3/29 23:59
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("vip线程来了"+i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new TestJoin());
        thread.start();
        for (int i = 0; i < 500; i++) {
            if (200==i){
                try {
                    // 类似于插队，等当前线程走完cpu分配资源走其他线程
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
