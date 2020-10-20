package com.dong.reflection;

/**
 * @author DongJian
 * @date Created in 2020/10/20 15:09
 * Utils: Intellij Idea
 * @description: 类的初始化过程
 * @version:1.0
 */
public class ClassInitializationTest {
    static {
        System.out.println("Main 类被加载！");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 1.new ->主动引用
        Son son = new Son(); // 若父类未初始化则先初始化父类
        // 2.反射 ->主动引用
        Class aClass = Class.forName("com.dong.reflection.Son");

        // 3.不会有类的引用发生
        System.out.println(Son.b); // 子类引用父类的静态变量，子类不会被加载
        Son[] sonArray = new Son[10]; // 通过数组定义类引用
        System.out.println(Son.N); // 引用常量
    }
}


class Father {

    static int b = 111;

    static {
        System.out.println("父类被加载！");
    }
}

class Son extends Father {
    static {
        System.out.println("子类被加载！");
        m = 300;
    }

    static int m = 100;
    // 常量
    static final int N = 200;
}