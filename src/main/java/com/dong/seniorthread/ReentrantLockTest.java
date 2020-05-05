package com.dong.seniorthread;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author DongJian
 * @Date Created in 2020/4/22 22:51
 * Utils: Intellij Idea
 * @Description: 测试lock锁 ReentrantLock
 * @Version:1.0
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrankLock1 reentrankLock1 = new ReentrankLock1();
        new Thread(reentrankLock1).start();
        new Thread(reentrankLock1).start();
        new Thread(reentrankLock1).start();
    }

}
class ReentrankLock1 implements Runnable{
    //总票数
    int ticketNums = 10;
    // 定义锁
    private final ReentrantLock reentrantLock = new ReentrantLock();
    @Override
    public void run() {

        while (true){

            try {
                //加锁
                reentrantLock.lock();
                if (ticketNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }
            } finally {
                //释放锁
                reentrantLock.unlock();
            }
        }
    }
}