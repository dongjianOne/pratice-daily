package com.dong.test;

import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Value;

import java.io.Console;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author DongJian
 * @Date Created in 2020/6/28 9:09
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class Test {
    @Value("${ra.gzPushRule}")
    public static List<String> list = new ArrayList<>(10);
    public static void main(String[] args) {
//        System.out.println(isMatching("11GH1111", "GH*"));
        Map<String, String> map = new HashMap<>();
        map.put("190203:004:447:3801:3696:Mon Mar 23 00:00:00 CST 2020", "1");
        if (map.containsKey("190203:004:447:3801:3696:Mon Mar 23 00:00:00 CST 2020")) {
            System.out.println("hello");
        }

        BigDecimal bigDecimal = new BigDecimal("100.0");
        System.out.println("bigDecimal:"+bigDecimal.subtract(BigDecimal.ZERO));

        System.out.println("--强制类型转换：小数转为整型采用‘去1法’无条件舍弃小数点后数字--");
        double d = 0.1d;
        int in = (int) d;
        System.out.println(in);
        System.out.println("list--"+list);

    }
    /**
     * @Description 字符串通配符处理
     * @Author dongjian 2020/7/14 16:56
     * @Param [src, des]
     * @return boolean
     **/
    public static boolean isMatching(String src, String des) {
        String des1 = des.replace("*", "\\w*");
        des1 = des1.replace("?", "\\w{1}");
        Pattern p = Pattern.compile(des1);
        Matcher m = p.matcher(src);
        return m.matches();
    }
}
