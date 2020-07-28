package com.dong.test;

/**
 * @Author DongJian
 * @Date Created in 2020/7/25 13:42
 * Utils: Intellij Idea
 * @Description: boolean result = obj instanceof Class:测试一个对象是否为一个类的实例
 * obj为对象 Class为一个类或者接口，当obj是Class直接或者间接的子类或者是接口实现类，那么返回true
 * @Version:1.0
 */
public class TestInstanceof {

    public static void main(String[] args) {
        // 编译器会检查obj是否能转化成Class,obj不能是基本数据类型
        int i = 0;
        // boolean b = i instanceof Integer; 编译报错
        // i instanceof Object; 编译报错
        System.out.println("---------------j instanceof Integer----------------");
        Integer j = 0;
        System.out.println(j instanceof Integer);
        System.out.println("---------------null instanceof Integer--------------");
        // 如何obj为null则返回false
        System.out.println(null instanceof Integer);
        if (1==1 & 1==1){
            System.out.println("&");
        }else {
            System.out.println("!&");
        }
    }
}
