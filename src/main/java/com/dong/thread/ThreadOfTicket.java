package com.dong.thread;

/**
 * @Author DongJian
 * @Date Created in 2020/3/28 22:39
 * Utils: Intellij Idea
 * @Description: 模拟买票
 * @Problem: 并发问题：多个线程操作同一个资源时，数据紊乱
 * @Version:1.0
 */
public class ThreadOfTicket implements Runnable {
    // 票数
    private int ticketNum = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                break;
            }
            try {
                // 模拟延迟
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNum-- + "张票！");
        }
    }

    public static void main(String[] args) {
        ThreadOfTicket threadOfTicket = new ThreadOfTicket();
        new Thread(threadOfTicket, "小明").start();
        new Thread(threadOfTicket, "小红").start();
        new Thread(threadOfTicket, "黄牛党").start();
    }
}
