package com.dong.generics;

/**
 * @Author DongJian
 * @Date Created in 2020/7/24 13:21
 * Utils: Intellij Idea
 * @Description: 1.泛型接口实现-明确类型参数变量
 * 注意：类上声明的泛型只对非静态变量有效
 * @Version:1.0
 */
public class GenericsInterImpl implements GenericsInter<String> {

    @Override
    public void show(String s) {
        System.out.println("泛型接口实现-明确类型参数变量:" + s);
    }

    public static void main(String[] args) {
        GenericsInterImpl g1 = new GenericsInterImpl();
        g1.show("dongjian");
        GenericsInterImpl2 g2 = new GenericsInterImpl2();
        g2.show(100);
    }
}
