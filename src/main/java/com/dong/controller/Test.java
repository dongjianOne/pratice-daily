package com.dong.controller;

import java.math.BigDecimal;

/**
 * @Author DongJian
 * @Date Created in 2020/5/6 0:41
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class Test {
    public static void main(String[] args) {
        String str = "24.19";
        BigDecimal bigDecimal = new BigDecimal(0.1);
        BigDecimal bigDecimal3 = new BigDecimal(str);

        BigDecimal bigDecimal1 = BigDecimal.ZERO;
        BigDecimal add = bigDecimal3.add(bigDecimal1);
        BigDecimal add1 = bigDecimal.add(bigDecimal3);
        System.out.println(bigDecimal1);
        System.out.println(add);
        System.out.println(0.1*3);
        System.out.println(0.5*3);
    }
}
