package com.dong.threadsafety;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author DongJian
 * @Date Created in 2020/4/12 20:46
 * Utils: Intellij Idea
 * @Description: CopyWriteArrayList Juc包下线程安全的集合
 * @Version:1.0
 */
public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                copyOnWriteArrayList.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(copyOnWriteArrayList.size());
    }
}
