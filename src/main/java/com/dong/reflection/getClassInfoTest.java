package com.dong.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import com.dong.lambda.User;
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

        System.out.println("----------------------获取类的属性(成员变量)---------------------------");
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
        // 获取接口
        Class<?>[] interfaces = c1.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        // 利用反射获取父类
        Class<?> superclass = c1.getSuperclass();
        System.out.println("superclass:" + superclass);
        // 利用反射创建类的实例
        Object o = c1.newInstance();
        User user = (User) o;
        user.setAge("20");
        user.setName("dongjian");
        System.out.println("c1.newInstance():"+user);

        Object obj = c1.newInstance();
        User u2 = (User) obj;
        Field nameField = c1.getDeclaredField("name");
        // 添加访问权限
        nameField.setAccessible(true);
        nameField.set(u2, "dongjian");
        System.out.println("u2:" + u2);

        // 上面是在成员变量上使用setAccessible() 还可以再方法上使用
        Object o2 = c1.newInstance();
        User u3 = (User) o2;
        Method getName1 = c1.getDeclaredMethod("setName",String.class);
        getName1.setAccessible(true);
        // 参数1:调用方法的对象，参数2：调用方法的参数
        getName1.invoke(u3, "dongjianone");
        System.out.println(u3);

        // 操作构造方法
        Constructor constructor = c1.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        // 构造对象实例
        User u5 = (User) constructor.newInstance("dongjianConstructor");
        System.out.println("getConstructor:"+u5.getName());
    }
}
