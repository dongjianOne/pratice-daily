package com.dong.designpattern;

/**
 * @Author DongJian
 * @Date Created in 2020/5/15 0:31
 * Utils: Intellij Idea
 * @Description: 单例涉及模式的几种实现方式
 * @Version:1.0
 */
public class Singleton {
    /**
     * 饿汉式:访问性能高，线程安全，但是初始化即创建会造成一定的资源浪费
     */
    //1.定义一个静态的实例对象，类加载时初始化
    private static Singleton instance = new Singleton();

    //2.私有的构造方法，不允许外部直接new对象
    private Singleton() {
    }

    //3.提供一个全局的访问方法
    public static Singleton getInstance() {
        return instance;
    }

//    public static void main(String[] args) {
//        Singleton singleton = new Singleton();
//        System.out.println(getInstance());
//    }
}

/**
 * 懒汉式:访问效率高，延迟初始化，用到时再创建资源利用率高，但是非线程安全
 */
final class SingletonLazy {
    //1.定义一个静态的实例对象
    private static SingletonLazy instance = null;

    //2.私有构造方法，不允许外部直接new对象
    private SingletonLazy() {
    }

    //3.全局的访问方法
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
