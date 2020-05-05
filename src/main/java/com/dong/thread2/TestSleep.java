package com.dong.thread2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author DongJian
 * @Date Created in 2020/3/29 22:09
 * Utils: Intellij Idea
 * @Description: 网络延迟 1.模拟倒计时 2.模拟获取系统当前时间
 * @Version:1.0
 */
public class TestSleep {

    public static void main(String[] args) {
//        tenDown();

        // 2.打印系统当前时间
        Date startTime = new Date(System.currentTimeMillis());// 获取系统当前时间
        while (true){
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startTime = new Date(System.currentTimeMillis());//更新当前系统时间
        }
    }
    // 1.模拟倒计时
    public static void tenDown(){
        int num = 10;
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num--);
            // 时间用完了即退出
            if (num<=0){
                break;
            }
        }
    }
}
