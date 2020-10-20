package com.dong.reflection;

/**
 * @author DongJian
 * @date Created in 2020/10/20 14:57
 * Utils: Intellij Idea
 * @description: 类加载：1.加载 2.链接（验证、准备、解析） 3.初始化
 * @version:1.0
 */
public class ClassLoadingTest {
    public static void main(String[] args) {
        // 创建A对象
        A a = new A();
        System.out.println(A.m);
    }
}

class A {
    static {
        System.out.println("A类的静态代码块");
        // 赋值
        m = 300;
    }

    static int m = 666;

    // 构造函数
    public A() {
        System.out.println("A类的构造函数");
    }
}