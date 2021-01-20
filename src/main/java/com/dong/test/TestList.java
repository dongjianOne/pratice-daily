package com.dong.test;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class TestList {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(10);
//        System.out.println("---"+list.size());
//        String format = LocalDate.now().format(formatter);
//        System.out.println("date:"+format);
        log.info("--------------------------------集合前后赋值变化:set会导致后面的集合值也会发生变化--------------------------------");
        List<User> us1 = Lists.newArrayList();
        User u1 = new User();
        u1.setName("曹操");
        u1.setAge(20);
        us1.add(u1);
        List<User> us2 = new ArrayList<>(us1);
        System.out.println("修改us1前us2的值："+ us2);
        us1.clear();
        // 改变us1 值
//        us1.forEach(u -> {
//            u.setName("刘备");
//        });
        User u3 = new User();
        u3.setName("关羽");
        u3.setAge(30);
        us1.add(u3);
        System.out.println("修改us1后us2的值："+ us2);
    }
}
