package com.dong.test;

import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Value;

import java.io.Console;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
//        map.put("190203:004:447:3801:3696:Mon Mar 23 00:00:00 CST 2020", "1");
//        if (map.containsKey("190203:004:447:3801:3696:Mon Mar 23 00:00:00 CST 2020")) {
//            System.out.println("hello");
//        }
//
//        BigDecimal bigDecimal = new BigDecimal("100.0");
//        System.out.println("bigDecimal:"+bigDecimal.subtract(BigDecimal.ZERO));
//
//        System.out.println("--强制类型转换：小数转为整型采用‘去1法’无条件舍弃小数点后数字--");
//        double d = 0.1d;
//        int in = (int) d;
//        System.out.println(in);
//        System.out.println("list--"+list);
        map.put("1", "a");
        map.put("2", "b");
        List<String> collect = map.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.toList());
        System.out.println(String.join("&", collect));

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

        /**
         * 经典的HashMap使用的方法

         优点和缺点:

         ①拉链法处理冲突简单，且无堆积现象，即非同义词决不会发生冲突，因此平均查找长度较短；

         ②由于拉链法中各链表上的结点空间是动态申请的，故它更适合于造表前无法确定表长的情况；

         ③**开放定址法为减少冲突，要求装填因子α较小**，故当结点规模较大时会浪费很多空间。而拉链法中可取`α≥1`，且结点较大时，拉链法中增加的指针域可忽略不计，因此节省空间；

         ④在用拉链法构造的散列表中，删除结点的操作易于实现。只要简单地删去链表上相应的结点即可。

         而对开放地址法构造的散列表，删除结点不能简单地将被删结点的空间置为空，否则将截断在它之后填人散列表的同义词结点的查找路径。
         这是因为各种开放地址法中，空地址单元(即开放地址)都是查找失败的条件。因此在 用开放地址法处理冲突的散列表上执行删除操作，
         **只能在被删结点上做删除标记，而不能真正删除结点**。
         */
}
