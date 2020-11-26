package com.dong.ThreadLoacl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author DongJian
 * @date Created in 2020/11/26 9:36
 * Utils: Intellij Idea
 * @description:
 * @version:1.0
 */
public class ThreadLoaclNormalUsage00 {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date1 = new ThreadLoaclNormalUsage00().date(10);
                System.out.println("date1:" + date1);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String date2 = new ThreadLoaclNormalUsage00().date(1000);
                System.out.println("date2:" + date2);
            }
        }).start();
    }

    public String date(int secounds) {
        Date date = new Date(1000 * secounds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
