package com.dong.generics;

/**
 * @Author DongJian
 * @Date Created in 2020/7/24 13:23
 * Utils: Intellij Idea
 * @Description: 2.泛型接口实现-不明确类型参数变量
 * @Version:1.0
 */
public class GenericsInterImpl2 implements GenericsInter {
    @Override
    public void show(Object o) {
        System.out.println("泛型接口实现-不明确类型参数变量:" + o);
    }
}
