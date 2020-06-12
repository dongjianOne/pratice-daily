package com.dong.datacheck;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author DongJian
 * @Date Created in 2020/5/25 19:34
 * Utils: Intellij Idea
 * @Description: 利用正则表达式进行参数校验
 * @Version:1.0
 */
public class CheckParams {
    /**
     * 长度为6-16个字符：.{6,16}
     * 不能包含空格：\\S*
     * 不能是9位以下纯数字：(.*\\D.*){1,8}|.{9,}
     * @param str
     * @return
     */
    public static boolean matchs(String str,Integer minLength,Integer maxLength) {
        //最大长度 最小长度
        String regex = ".{"+minLength+","+maxLength+"}";
        //不能有空格
        String trim = "\\S*";
        //不能是9一下纯数字格式
        String allNumber = "(.*\\D.*){1,8}|.{9,}";
        List<String> ruleList = Lists.newArrayList();
        ruleList.add(regex);
        ruleList.add(trim);
        boolean flag = true;
        for (String s1 : ruleList){
            if (!str.matches(trim)) {
                flag = false;
                break;
            }
        }
       return flag;
    }

    public static void main(String[] args) {
//        System.out.println(matchs("1234a",6,16));
        // 是否为数字
        String pattern = "^[-\\+]?[\\d]*$";
        String s1 = "6.12";
        String s2 = "20";
//        System.out.println(cpmareToNumber(s1,s2));
        System.out.println(s1.matches(pattern));
    }
    public static boolean cpmareToNumber(String s1, String s2){
        Integer i1 = Integer.valueOf(s1);
        Integer i2 = Integer.valueOf(s2);
        if (i2 > i1){
            return true;
        }else {
            return false;
        }
    }
}
