package com.dong.ThreadLoacl;

/**
 * @author DongJian
 * @date Created in 2020/11/26 15:12
 * Utils: Intellij Idea
 * @description: 非线程安全 :资源抢占
 * 线程隔离：
 *  多线程的情况下，每个线程中的变量相互独立
 * ThreadLocal：
 *   1.set(): 将变量绑定到当前线程
 *   2.get(): 获取当前线程绑定的变量
 * @version:1.0
 */
public class MyDemo1 {

    ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private String content;

    public String getContent() {
//        return content;
        return threadLocal.get();
    }

    public void setContent(String content) {
//        this.content = content;
        threadLocal.set(content);
    }


    public static void main(String[] args) {

        MyDemo1 demo = new MyDemo1();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println("---------------------------------------");
                    System.out.println(Thread.currentThread().getName() + "=====>" + demo.getContent());
                }
            }).start();
        }
    }
}
