package com.dong.thread2;

/**
 * @Author DongJian
 * @Date Created in 2020/3/28 23:51
 * Utils: Intellij Idea
 * @Description: 静态代理 模拟结婚
 *  真实对象和代理对象都要事先同一接口，代理对象要代理真实角色
 *  1.代理对象可以做一些真实对象做不了的事情 2.真实对象可以专注于做自己的事情
 * @Version:1.0
 */
public class Proxy  {
    public static void main(String[] args) {
        // 你要结婚
        You you = new You();
        // 交给婚庆公司处理
        WeddingCompany wc = new WeddingCompany(you);
        // 举行典礼
        wc.happyMarry();
//        new WeddingCompany(new You()).happyMarry();
    }
}
interface Marry{
    // 接口：结婚
    void happyMarry();
}
class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("我要结婚了，超级开心！");
    }
}
class WeddingCompany implements Marry{
    private Marry target;
    // 代理谁 --> 真实目标角色
    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        befor();
        // 这是真正的对象
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚后，收尾款！");
    }

    private void befor() {
        System.out.println("结婚前，布置会场！");
    }
}