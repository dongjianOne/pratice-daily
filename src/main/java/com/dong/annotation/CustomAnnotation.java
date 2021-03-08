package com.dong.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author DongJian
 * @date Created in 2020/10/17 15:52
 * Utils: Intellij Idea
 * @description:
 * @version:1.0
 */
@MyAnnotation1(value = "dongjian",age = 21)
public class CustomAnnotation {

    @MyAnnotation1(value = "dongjian",age = 21)
    public void test() {

    }
}

// 自定义注解
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1 {
    String value() default "";

    int age() default 20;

    int id() default -1; //如果默认值为-1,则不存在

    String[] schools() default {"北大", "清华"};
}
