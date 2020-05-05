package com.dong.proxy;

/**
 * @Author DongJian
 * @Date Created in 2020/4/23 13:43
 * Utils: Intellij Idea
 * @Description: 静态代理模式 ：出租-租房过程
 * @Version:1.0
 * 静态代理的优点：
 * 1.使真实角色更加纯粹，不需要再关注公共的事情
 * 2.代理角色代理完成公共操作，实现业务分工
 * 3.公共操作发生变化需要扩展时，更加集中和方便
 */
//客户：一般接触不到房东，而是找的代理即中介
public class staticProxy {
    public static void main(String[] args) {
        //1.先准备好房子：房东要租房
        Host host = new Host();
        //2.代理：中介代理房子
        Proxy proxy = new Proxy(host);
        //3.客户找到中介，完成租房
        proxy.rent();
    }
}
//真实角色：房东（也可以理解为房子）
class Host implements Rent{

    @Override
    public void rent() {
        //要出租房
        System.out.println("房屋出租，物美价廉！");
    }
}
//代理角色：中介 需要做一些房东不做的附属操作
class Proxy implements Rent{
    private Host host;
    // 无参构造方法
    public Proxy() {
    }
    //有参构造方法
    public Proxy(Host host) {
        this.host = host;
    }
    /**租房*/
    @Override
    public void rent() {
        //1.带客户看房
        seeHost();
        // ...其他操作
        //2.收取中介费
        getAgencyFee();
    }
    /**看房*/
    private void seeHost(){
        System.out.println("带客户看房");
    }
    /**收取中介费*/
    private void getAgencyFee(){
        System.out.println("收取中介费");
    }
}

