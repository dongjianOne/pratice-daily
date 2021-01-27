package com.dong.problem;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * YYYY-MM-dd 导致的日期错误
 */
public class DateFormatProblem {

    public static void main(String[] args) {

        // 创建 2020-12-31
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020,Calendar.DECEMBER,31);

        // YYYY-MM-dd
        SimpleDateFormat dfYYYY = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println("YYYY-MM-dd 输出:" + dfYYYY.format(calendar.getTime()));

        // yyyy-MM-dd
        SimpleDateFormat dfyyyy = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("yyyy-MM-dd 输出:" + dfyyyy.format(calendar.getTime()));
    }
}
