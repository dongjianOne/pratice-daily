package com.dong.threadsafety;

/**
 * @Author DongJian
 * @Date Created in 2020/4/12 16:12
 * Utils: Intellij Idea
 * @Description: 模拟不安全的买票
 * @Version:1.0
 */
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        //开启三个线程，模拟三个人买票
        new Thread(buyTicket,"苦逼的我").start();
        new Thread(buyTicket,"牛逼的你们").start();
        new Thread(buyTicket,"可恶的黄牛党").start();
    }
}

class BuyTicket implements Runnable {
    //票数
    private int ticketNum = 10;
    // 外部停止方式
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            buy();
        }
    }

    private synchronized void buy() {
        // 如果票数小于或者等于0那就不再卖了
        if (ticketNum <= 0) {
            flag = false;
            return;
        }
        //模拟买票的延迟
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票 票数减1
        System.out.println(Thread.currentThread().getName() + "拿到：" + ticketNum--);
    }
}