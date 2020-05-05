package com.dong.threadsafety;

import lombok.Data;
import lombok.SneakyThrows;

import java.math.BigDecimal;

/**
 * @Author DongJian
 * @Date Created in 2020/4/12 17:05
 * Utils: Intellij Idea
 * @Description: 不安全的取钱
 * @Version:1.0
 */
public class UnSafeBank {
    public static void main(String[] args) {
        Account account = new Account(new BigDecimal(1000),"结婚基金");
        new Thread(new Drawing(account,new BigDecimal(90)),"你媳妇").start();
        new Thread(new Drawing(account,new BigDecimal(50)),"你").start();
    }
}

//账户
@Data
class Account {
    /*
    余额
     */
    private BigDecimal money;
    /**
     * 卡名
     */
    private String AccountName;

    public Account(BigDecimal money, String accountName) {
        this.money = money;
        AccountName = accountName;
    }
}
//银行
class Drawing implements Runnable{
    //账户
    Account account;
    //取钱金额
    BigDecimal drawingMony;
    //现在的金额
    BigDecimal nowMoney = BigDecimal.ZERO;

    public Drawing(Account account, BigDecimal drawingMony) {
        this.account = account;
        this.drawingMony = drawingMony;
    }

    @Override
    public  void run() {
        //变化的是账户里的钱所以要给账户这个对象加锁
        synchronized (account){
            if (drawingMony.compareTo(account.getMoney())>0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
                return;
            }
            //模拟延迟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //取钱 卡里金额 = 余额-取出的钱
            BigDecimal subtract = account.getMoney().subtract(drawingMony);
            account.setMoney(subtract);
            //你手里的钱
            nowMoney = nowMoney.add(drawingMony);
            System.out.println("余额为："+account.getMoney());
            //手里的钱
            System.out.println(Thread.currentThread().getName()+"手里的钱："+nowMoney);
        }
    }
}