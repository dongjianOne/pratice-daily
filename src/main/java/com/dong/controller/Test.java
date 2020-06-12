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
        System.out.println("13&17--"+(0x13&0x17));
        String s1 = "+B-C";
        System.out.println(s1.replaceAll("\\+|\\-", ""));
        char c = 'A';
        System.out.println("c----"+String.valueOf(c));
        System.out.println("index----"+(s1.indexOf("B")-1));
       String  pattern = "";
       String s2 = "127E+8";
        System.out.println("pattern----"+s2.matches(pattern));
        System.out.println(new BigDecimal("1.27E+8"));
        System.out.println(s2.replaceAll("\\.|E|\\+", ""));
        System.out.println("s-----"+"s");
        System.out.println("h : b".replaceAll("\\s", ""));
        //分隔符
        String s3 = "王阳明:108";
        System.out.println(s3.split("：|:").length);
        System.out.println("s3--contains"+(s3.contains("：")||s3.contains(":")));
//        System.out.println(new BigDecimal(""));
        String s4 = "ss  ";
        System.out.println("s==="+s4.replaceAll("\\s", "").length());

    }
}
