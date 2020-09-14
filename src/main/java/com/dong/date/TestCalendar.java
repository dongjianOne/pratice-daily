package com.dong.date;

import org.apache.poi.ss.usermodel.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author DongJian
 * @Date Created in 2020/8/17 14:14
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class TestCalendar {
    public static void main(String[] args) {
        Date today = new Date();
        Calendar calender = Calendar.getInstance();
        calender.setTime(today);
        System.out.println("年："+calender.get(Calendar.YEAR));
        System.out.println("月："+calender.get(Calendar.DAY_OF_MONTH));
        System.out.println("日："+calender.get(Calendar.DATE));


    }
}
