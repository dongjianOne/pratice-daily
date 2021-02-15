package com.dong.test;

/**
 * Java 类初始化加载顺序
 * 类的初始化分为两种：1.本类 2.有父类
 * 1.本类：
 * 静态变量->静态代码块->普通变量->普通代码块->构造方法
 *
 * 2.有父类的情况：
 * 父类的静态变量->父类的静态代码块->子类的静态变量->子类的静态代码块
 * ->父类的普通变量->父类的普通代码块->父类的构造方法->子类的普通变量->子类的普通代码块->子类的构造方法
 * 补充：静态变量和静态代码块在类加载时就初始化，并且只加载一次
 */
public class InitializationJavaTest extends FatherObject{
    // 静态变量
    private static String name = "djone";
    // 普通变量
    private String generName = "dong";

    // 静态代码块
    static {
        System.out.println("我是静态代码块");
    }

    // 代码块
    {
        System.out.println("我是普通代码块");
    }

    // 构造方法
    public InitializationJavaTest() {
        System.out.println("我是构造方法");
    }

    public static void main(String[] args) {
        System.out.println("------------------测试类初始化代码的初始化顺序-----------------------");
        // 构建类的实例
        InitializationJavaTest initializationJavaTest = new InitializationJavaTest();
    }
}
class FatherObject {
    // 静态代码块
    static {
        System.out.println("我是父类的静态代码块");
    }
    // 代码块
    {
        System.out.println("我是父类的普通代码块");
    }

    // 构造方法
    public FatherObject() {
        System.out.println("我是父类的构造方法");
    }
}
