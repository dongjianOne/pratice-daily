package com.dong.annotation;

import java.lang.annotation.*;

/**
 * @author DongJian
 * @date Created in 2020/10/17 14:28
 * Utils: Intellij Idea
 * @description: 四个元注解
 * @version:1.0
 */
public class MetaAnnotation {

    public void test() {

    }
}

/**
 * @return
 * @Description 定义一个注解
 * @Author dongjian 2020/10/17 14:29
 * @Param
 **/
// Target 标识注解作用的范围（可以用在哪些地方）
@Target({ElementType.METHOD,ElementType.TYPE})
// Retention 表示注解在什么地方还有效
@Retention(RetentionPolicy.RUNTIME)
// Documented 表示是否将注解生成到JavaDoc中
@Documented
// Inherited 子类继承父类的注解
@Inherited
@interface MyAnnotation {

}
