package com.dong.lambda;

import lombok.Data;

import java.math.BigDecimal;
import java.util.function.*;

/**
 * @Author DongJian
 * @Date Created in 2020/5/16 17:14
 * Utils: Intellij Idea
 * @Description: Java 8 常用的函数式接口
 * @Version:1.0
 */
public class Testj8Lambda {

    public static void main(String[] args) {
        //Predicate -- test(T t) 判断真假
        Predicate<Integer> predicate = x -> x > 200;
        Student st = new Student("kobe", 38, 198);
        System.out.println("kobe的身高有两米吗？---" + predicate.test(st.getHight()));
        //Consumer -- accept(T t) 消费消息
        Consumer<String> consumer = System.out::println;
        consumer.accept("hello world");
        // Function -- R apply(T t) 将T映射成R 转换功能  Lambda很多方法都用到--map
        Function<Student, String> function = Student::getName;
        String name = function.apply(st);
        System.out.println(name);// kobe
        //Supplier -- T get() 生产消息
        Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());
        Integer integer = supplier.get();
        System.out.println(integer);
        //UnaryOperator -- T apply(T t) 一元操作 逻辑非（！）
        UnaryOperator<Boolean> unaryOperator = u -> !u;
        Boolean apply = unaryOperator.apply(true);
        System.out.println(apply);
        //binaryOperator -- apply(T t,U u) 二元操作
        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
        Integer apply1 = binaryOperator.apply(2, 3);
        System.out.println(apply1);
        System.out.println(test(() -> "Hello lambda,I am functionalInterface for test"));
    }

    public static String test(Worker worker) {
        return worker.worker();
    }
}

/**
 * 自定义一个函数式接口
 */
interface Worker {
    String worker();
}

@Data
class Student {
    /**
     * 有参构造函数
     *
     * @param name
     * @param age
     * @param hight
     */
    public Student(String name, int age, int hight) {
        this.name = name;
        this.age = age;
        this.hight = hight;
    }

    public Student() {
    }

    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 身高
     */
    private int hight;
}
