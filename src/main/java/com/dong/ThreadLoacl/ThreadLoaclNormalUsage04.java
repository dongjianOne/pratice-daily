package com.dong.ThreadLoacl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author DongJian
 * @date Created in 2020/11/26 9:36
 * Utils: Intellij Idea
 * @description: 使用ThreadLocal为每个线程提供单独的对象，避免共享一个对象和线程安全问题
 * @version:1.0
 */
public class ThreadLoaclNormalUsage04 {

    // 线程池
    public static ThreadLocal<User> holder = new ThreadLocal<User>();

    public static void main(String[] args) {
        new ThreadLoaclNormalUsage04().process();

    }

        private void process() {
            User user = new User("DJ");
            holder.set(user);
            new Service1().process();
        }
    class Service1 {
        private void process() {
            User user1 = holder.get();
            System.out.println("service1 user1:" + user1.name);
        }
    }

    class Service2 {
        private void process() {
            User user2 = holder.get();
            System.out.println("service1 user2:" + user2);
        }
    }
    class Service3 {
        private void process() {
            User user3 = holder.get();
            System.out.println("service1 user3:" + user3);
        }
    }
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}
