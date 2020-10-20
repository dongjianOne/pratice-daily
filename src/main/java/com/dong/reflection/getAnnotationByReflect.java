package com.dong.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @version 1.0
 * @author:dongjian
 * @date:2020/10/20 0020
 * @describe: 通过反射获取注解
 */
public class getAnnotationByReflect {

    public static void main(String[] args) throws NoSuchFieldException {
        // 1.通过反射获取注解
        Class c1 = User.class;
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        // 2.获取指定的注解
        TableDong tableDong = (TableDong) c1.getAnnotation(TableDong.class);
        System.out.println(tableDong.value());

        // 3.获取指定属性上的注解
        Class c2 = User.class;
        Field f1 = c2.getDeclaredField("age");
        ColumnDong columnDong = f1.getAnnotation(ColumnDong.class);
        System.out.println(columnDong.name());
    }
}


@TableDong("db_user")
class User {
    @ColumnDong(name = "name", type = "varchar", length = 20)
    private String name;
    @ColumnDong(name = "age", type = "int", length = 20)
    private int age;
    @ColumnDong(name = "sex", type = "varchar", length = 20)
    private String sex;

    public User(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }
}

// 自定义注解 TableDong
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableDong {
    String value();
}

// 自定义注解 ColuunDong
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ColumnDong {
    String name();

    String type();

    int length();
}