package com.dong.threadsafety;

/**
 * @Author DongJian
 * @Date Created in 2020/4/12 21:11
 * Utils: Intellij Idea
 * @Description: 线程死锁：多个线程互相抱着对方的资源，然后形成僵持的状态
 * @Version:1.0
 */
public class DeadLock {
    public static void main(String[] args) {
        MakeUp g1  = new MakeUp(0,"灰姑娘");
        MakeUp g2  = new MakeUp(1,"白雪公主");
        g1.start();
        g2.start();
    }
}
// 口红
class LipStick{

}
//镜子
class Mirror{

}

class MakeUp extends Thread{
    //需要的资源只有一份 用static修饰
    static LipStick lipStick = new LipStick();
    static Mirror mirror = new Mirror();
    //选择
    int choice;
    //化妆的女孩
    String girlName;
    //构造器
    MakeUp(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }
    @Override
    public void run() {

        try {
            //化妆
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 化妆
     * @throws InterruptedException
     */
    private void makeUp() throws InterruptedException {
        if (0==choice){
            synchronized (lipStick){
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);
            }
            //释放掉口红的锁再去拿镜子的锁
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
            }
        }else {
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
                Thread.sleep(1000);
            }
            //释放掉镜子的锁再去拿口红的锁
            synchronized (lipStick){
                System.out.println(this.girlName+"获得口红的锁");
            }
        }
    }
}