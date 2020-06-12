package com.dong.spring.sourcecode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author DongJian
 * @Date Created in 2020/5/19 16:03
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
@ComponentScan("com.dong.spring.sourcecode")
public class SimpleConfig {

    @Bean
    public AnnoUser annoUser(){
        return new AnnoUser();
    }
}
