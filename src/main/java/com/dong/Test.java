package com.dong;

import org.assertj.core.util.Maps;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;
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
    public static void main(String[] args) {
//        System.out.println(isMatching("11GH1111", "GH*"));
        Map<String,String> map = new HashMap<>();
        map.put("190203:004:447:3801:3696:Mon Mar 23 00:00:00 CST 2020","1");
        if (map.containsKey("190203:004:447:3801:3696:Mon Mar 23 00:00:00 CST 2020")){
            System.out.println("hello");
        }

    }
    public static boolean isMatching(String src,String des){
        String des1 = des.replace("*", "\\w*");
        des1 = des1.replace("?", "\\w{1}");
        Pattern p = Pattern.compile(des1);
        Matcher m = p.matcher(src);
        return m.matches();
    }
}
