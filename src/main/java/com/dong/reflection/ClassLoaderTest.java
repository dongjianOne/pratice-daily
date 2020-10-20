package com.dong.reflection;

/**
 * @author DongJian
 * @date Created in 2020/10/20 15:34
 * Utils: Intellij Idea
 * @description:
 * @version:1.0
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        // 获取系统类加载器的父类加载器 -> 扩展加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        // 获取扩展加载器的父类加载器 -> 父类加载器 (c/c++)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        // 测试JDK内置的类是由谁加载的
        ClassLoader classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader); // null 根加载器加载
        // 测试当前类的加载器
        ClassLoader currentClassLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(currentClassLoader); // 系统类加载器

        // 获取系统类加载器可以加载的路径
        String allPath = System.getProperty("java.class.path");
        System.out.println(allPath);
        /*
         双亲委派机制保证安全性
         **/
    }
}

