package com.dong.proxy;

/**
 * @Author DongJian
 * @Date Created in 2020/4/25 15:36
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */

/**
 * 真实角色
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("新增一个用户");
    }

    @Override
    public void delete() {
        System.out.println("删除一个用户");
    }

    @Override
    public void update() {
        System.out.println("修改一个用户");
    }

    @Override
    public void select() {
        System.out.println("查询一个用户");
    }
}
