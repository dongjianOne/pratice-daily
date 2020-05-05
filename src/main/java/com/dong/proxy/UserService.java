package com.dong.proxy;

/**
 * @Author DongJian
 * @Date Created in 2020/4/25 15:34
 * Utils: Intellij Idea
 * @Description: 练习：用户业务操作 增删改查
 * @Version:1.0
 */

/**
 * 抽象角色
 */
public interface UserService {
    /**
     * 增删改查
     */
    public void add();

    public void delete();

    public void update();

    public void select();
}
