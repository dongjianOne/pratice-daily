package com.dong.thread2;

/**
 * @Author DongJian
 * @Date Created in 2020/4/11 22:23
 * Utils: Intellij Idea
 * @Description: 用户线程和守护线程 JVM不需要等待守护线程执行完毕
 * @Version:1.0
 */
public class ThreadDaemon {

    public static void main(String[] args) {
        God god = new God();
        You1 you1 = new You1();

        Thread t1 = new Thread(god);
        t1.setDaemon(true); //默认为用户线程 false
        t1.start();

        new Thread(you1).start();
    }
}

/**
 * 守护线程
 */
class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("我会一直保佑你的！");
        }
    }
}

/**
 * 用户线程
 */
class You1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36000; i++) {
            System.out.println("开心的活着，一生平安！");
        }
        System.out.println("---->goodBye World ");
    }
}