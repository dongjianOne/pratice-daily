package com.dong.lambda;

import com.google.common.base.Function;

import java.util.function.BiFunction;

/**
 * @Author DongJian
 * @Date Created in 2020/9/14 9:42
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class FunctionInterface {

    public static void main(String[] args) {
        // ::构造静态函数引用
        Function<String, Integer> stringIntegerFunction = Integer::parseInt;
        Integer apply = stringIntegerFunction.apply("123");
        System.out.println("apply:" + apply);
        // ::构造非静态函数
        String content = "hello JDK1.8";
        Function<Integer, String> sub = content::substring;
        String apply1 = sub.apply(1);
        System.out.println("apply1:" + apply1);
        // ::构造函数的引用 类名::new
        BiFunction<String, String, User> biFunction = User::new;
        User admin = biFunction.apply("admin", "20");
        System.out.println("admin:" + admin);
        // 函數接口引用作为参数传入
        toUpperCase(String::toUpperCase, "test");
    }

    static void toUpperCase(Function<String, String> function, String str) {
        String apply = function.apply(str);
        System.out.println("str:" + apply);
    }
}
