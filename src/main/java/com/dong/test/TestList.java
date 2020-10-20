package com.dong.test;

import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DongJian
 * @date Created in 2020/9/30 9:22
 * Utils: Intellij Idea
 * @description:
 * @version:1.0
 */
public class TestList {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        System.out.println("---"+list.size());
        String format = LocalDate.now().format(formatter);
        System.out.println("date:"+format);

    }
}
