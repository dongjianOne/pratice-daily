package com.dong.threadsafety;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author DongJian
 * @Date Created in 2020/4/12 20:14
 * Utils: Intellij Idea
 * @Description: 测试线程不安全的集合ArrayList
 * @Version:1.0
 */
public class TestArrayList {
    public static void main(String[] args) {
        List<String> list =new ArrayList();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                //变化的是list集合，所以要个list加锁，这样每次只有拿到锁才能执行add操作
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
