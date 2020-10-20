package com.dong.reflection;

import com.dong.lambda.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

/**
 * @author DongJian
 * @date Created in 2020/10/20 18:05
 * Utils: Intellij Idea
 * @description: 引用性能分析
 * @version:1.0
 */
public class QuotePerformanceReflect {

    // 1.普通调用
    public static void test0() {
        User user = new User();
        Instant timeStart = Instant.now();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        Instant timeEnd = Instant.now();
        System.out.println("普通调用10亿次所用的时间：" + Duration.between(timeEnd, timeStart).toMillis() / 1000.0);
    }

    // 2.反射方式调用
    public static void test1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName");
        Instant timeStart = Instant.now();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }
        Instant timeEnd = Instant.now();
        System.out.println("反射方式调用10亿次所用的时间：" + Duration.between(timeEnd, timeStart).toMillis() / 1000.0);
    }

    // 3.反射方式调用 关闭监测
    // 2.反射方式调用
    public static void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName");
        getName.setAccessible(true);
        Instant timeStart = Instant.now();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }
        Instant timeEnd = Instant.now();
        System.out.println("关闭监测10亿次所用的时间：" + Duration.between(timeEnd, timeStart).toMillis() / 1000.0);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test0();
        test1();
        test2();
    }
}
