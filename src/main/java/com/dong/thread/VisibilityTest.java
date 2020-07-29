package com.dong.thread;

/**
 * @Author DongJian
 * @Date Created in 2020/7/29 15:46
 * Utils: Intellij Idea
 * @Description: 线程可见性
 * @Version:1.0
 */
public class VisibilityTest {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!ready) {
                System.out.println(ready);
            }
            System.out.println(number);
        }
    }

    private static class WriterThread extends Thread {
        public void run(){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number = 100;
            ready = true;
        }
    }

    public static void main(String[] args) {
        // 开启线程
        new WriterThread().start();
        new ReaderThread().start();
    }
}
