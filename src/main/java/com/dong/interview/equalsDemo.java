package com.dong.interview;


import java.util.HashSet;
import java.util.Set;

/**
 * equals、==区别
 * @author dongjian
 */
public class equalsDemo {
    /**
     * 测试对象 User
     */
    static class User {
        private String name;
        private Integer age;

        /**
         * 构造方法
         * @param name
         */
        public User(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");

        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // true

        // set:无序不可重复
        Set<String> strSet = new HashSet<>();
        strSet.add(s1);
        strSet.add(s2);
        System.out.println(strSet.size()); // 1

        System.out.println("==============================>");
        // 下面会用到
        String s3 = "abc";
        String s4 = "abc";

        System.out.println(s3 == s4); // true
        System.out.println(s3.equals(s4)); // true

        Set<String> set2 = new HashSet<>();
        set2.add(s3);
        set2.add(s4);
        System.out.println(set2.size());

        User u1 = new User("dong");
        User u2 = new User("dong");
        System.out.println(u1 == u2); // false
        System.out.println(u1.equals(u2)); // false 此处是Object类中equals()

        Set<User> userSet = new HashSet<>();
        userSet.add(u1);
        userSet.add(u2);
        System.out.println(userSet.size()); // 2

        System.out.println("===========================================>");
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = "abc";
        String str4 =  "xxx";
        String str5 = "abc" + "xxx";
        String str6 = str3 + str4;

        System.out.println("str1==str2:" + (str1 == str2)); // false
        System.out.println("str1.equals(str2):" + (str1.equals(str2))); // true
        System.out.println("str1==str5:" + (str1 == str5)); // false
        System.out.println("str1==str6:" + (str1 == str6)); // false
        System.out.println("str5==str6:" + (str5 == str6)); // false
        System.out.println("str5.equals(str6):" + (str5.equals(str6))); // true
        System.out.println("str1.equals(str2.intern()):" + str1.equals(str2.intern())); // true







    }
}

