package com.dong.spring.sourcecode;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author DongJian
 * @Date Created in 2020/5/19 15:57
 * Utils: Intellij Idea
 * @Description: Spring IOC的创建过程 如何将一个对象加载进容器
 * @Version:1.0
 */
public class BeanInitialization {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SimpleConfig.class);
        System.out.println(applicationContext.getBean("user"));
        System.out.println(applicationContext.getBean("annoUser"));
        System.out.println(applicationContext.getBean("serviceUser"));
    }
}
