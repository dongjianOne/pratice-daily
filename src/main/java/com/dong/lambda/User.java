package com.dong.lambda;

import lombok.Data;

/**
 * @Author DongJian
 * @Date Created in 2020/9/14 10:12
 * Utils: Intellij Idea
 * @Description: 用于测试
 * @Version:1.0
 */
@Data
public class User {

    private String name;
    private String age;

    /**
     * @return
     * @Description 构造函数
     * @Author dongjian
     * @Param
     **/
    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
