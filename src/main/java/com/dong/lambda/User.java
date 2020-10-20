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

    // 无参构造方法
    public User() {
    }

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
    // 私有构造方法
    private User(String name) {
        this.name = name;
    }
    // 私有method

    private void test(){

    }
}
