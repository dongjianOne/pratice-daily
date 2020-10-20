package com.dong.reflection;

/**
 * @author DongJian
 * @date Created in 2020/10/17 16:31
 * Utils: Intellij Idea
 * @description: 创建Class类的几种方式
 * @version:1.0
 */
public class TestGetClass {

    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是：" + person.name);


        // 1.通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());
        // 2.forName() 方式获得
        Class c2 = Class.forName("com.dong.reflection.Student");
        System.out.println(c2.hashCode());
        // 3.通过类名.class方式获得
        Class<Student> c3 = Student.class;
        System.out.println(c3.hashCode());
        // 4.基本内置类型的包装类都有一个Type属性
        Class<Integer> c4 = Integer.TYPE;
        System.out.println(c4);

        // 获得父类的类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}

class Person {
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Student extends Person {
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "老师";
    }
}