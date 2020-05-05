package com.dong.thread;

/**
 * @Author DongJian
 * @Date Created in 2020/3/28 22:58
 * Utils: Intellij Idea
 * @Description: 线程模拟龟兔赛跑
 * @Version:1.0
 */
public class Race implements Runnable {
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            // 模拟兔子休息
            if ("兔子".equals(Thread.currentThread().getName()) && i % 10 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 判断比赛是否结束
            boolean b = gameOver(i);
            if (b) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    private static boolean gameOver(int i) {
        if (winner != null) {
            return true;
        }
        {
            if (i >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("胜利者是：" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
