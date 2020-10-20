package com.dong.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author DongJian
 * @date Created in 2020/10/20 16:13
 * Utils: Intellij Idea
 * @description: 通过反射获取类相关信息
 * @version:1.0
 */
public class getClassInfoTest {

    public static void main(String[] args) throws Exception {
        // 1.反射获取Class对象
        Class c1 = Class.forName("com.dong.lambda.User");

        // 获取类的名称
        String name = c1.getName(); //全称=包名+类名
        String simpleName = c1.getSimpleName(); // 类名
        System.out.println(simpleName);

        System.out.println("----------------------获取类的属性---------------------------");
        // 获取类的属性
        Field[] fields = c1.getFields();// 只能获取到public修饰的属性

        Field[] declaredFields = c1.getDeclaredFields(); // 获取所有属性
        System.out.println(declaredFields); // 全部属性

        Field field = c1.getDeclaredField("name"); // 获取指定属性
        System.out.println(field);
        System.out.println("----------------------获取类的方法---------------------------");
        // 获取类的方法
        System.out.println("----------------------1.获取类的方法 （getMethods）---------------------------");
        Method[] methods = c1.getMethods(); // 获取本类及其父类的public方法
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("----------------------2.获取类的方法 （declaredMethods）---------------------------");
        Method[] declaredMethods = c1.getDeclaredMethods(); // 获取本类的全部方法
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("----------------------3.获取指定的方法---------------------------");
        Method setName = c1.getDeclaredMethod("setName", String.class);
        Method getName = c1.getMethod("getName", null);
        System.out.println(setName);
        System.out.println(getName);

        System.out.println("----------------------获取构造器---------------------------");
        Constructor[] constructors = c1.getConstructors(); // 获取所有public构造器
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        constructors = c1.getDeclaredConstructors(); // 获取所有构造器
        for (Constructor constructor : constructors) {
            System.out.println("*" + constructor);
        }
        // 获取指定的构造器 输入构造器参数列表
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, String.class);
        System.out.println(declaredConstructor);

    }
}
