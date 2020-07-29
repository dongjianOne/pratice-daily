package com.dong.thread;

/**
 * @Author DongJian
 * @Date Created in 2020/7/29 13:22
 * Utils: Intellij Idea
 * @Description: 多线程情况下出现的数据共享问题
 * @Version:1.0
 */
public class ShareData {

    // 共享变量
    public static int count = 0;

    public static void main(String[] args) {
        final ShareData data = new ShareData();
        // 开启10个线程
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                // 执行体
                @Override
                public void run() {
                    try {
                        // 暂停1ms,增加并发出现的几率
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 100; j++) {
                        // +1
                        data.addCount();
                    }
                    System.out.println("count:" + count);
                }
            }).start();
        }
        try {
            // 主线程暂停三秒：保证上面的操作顺利完成
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count==" + count);
    }

    /**
     * @return void
     * @Description +1 synchronized:加锁
     * @Author dongjian 2020/7/29 13:36
     * @Param []
     **/
    public synchronized void addCount() {
        count++;
    }
}
