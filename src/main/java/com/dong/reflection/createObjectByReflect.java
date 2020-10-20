package com.dong.reflection;

import com.dong.lambda.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author DongJian
 * @date Created in 2020/10/20 17:29
 * Utils: Intellij Idea
 * @description:
 * @version:1.0
 */
public class createObjectByReflect {

    public static void main(String[] args) throws Exception {
        // 1.获取Class对象
        Class c1 = Class.forName("com.dong.lambda.User");
        // 构造一个对象
        User user = (User) c1.newInstance(); // 本质是调用类的无参构造方法
        System.out.println(user);

        // 2.通过构造器构造对象
        System.out.println("------------------------通过构造器构造对象------------------------");
        Constructor constructor = c1.getDeclaredConstructor(String.class, String.class);
        User u2 = (User)constructor.newInstance("dongjian","20");
        System.out.println(u2);

        // 3.通过反射调用普通方法
        System.out.println("------------------------通过反射调用普通方法------------------------");
        User u3 = (User) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(u3,"dongjian");
        System.out.println("u3:"+u3.getName());
        // 4.通过反射操作属性
        System.out.println("------------------------通过反射操作属性------------------------");
        User u4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true); // 不能直接操作私有属性或者方法，需要关闭安全监测
        name.set(u4,"kobe");
        System.out.println(u4.getName());
    }
}
