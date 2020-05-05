package com.dong.thread2;

/**
 * @Author DongJian
 * @Date Created in 2020/4/6 23:52
 * Utils: Intellij Idea
 * @Description: 测试观测线程的状态 state
 * @Version:1.0
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("i:"+i);
            }
            System.out.println(Thread.currentThread().getName()+"已运行完！");
        });
        // 观察线程状态
        Thread.State state = thread.getState();
        System.out.println("刚创建时的状态："+state);
        // 观察启动后的状态
        // 启动线程
        thread.start();
        state = thread.getState();
        // 就绪状态
        System.out.println("刚启动的状态："+state);

        while (state != Thread.State.TERMINATED){
            Thread.sleep(100);
            // 更新线程状态
            state = thread.getState();
            System.out.println(state);
        }
    }
}
