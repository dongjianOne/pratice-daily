package com.dong.proxy;

/**
 * @Author DongJian
 * @Date Created in 2020/4/25 15:37
 * Utils: Intellij Idea
 * @Description: 业务场景：新增业务 例如添加日志，此时可以新加一个代理类
 * @Version:1.0
 */

/**
 * 代理角色
 */
public class UserProxy implements UserService {
    private UserServiceImpl userService;

    //构造函数
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        //日志操作
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        //日志操作
        log("delete");
        userService.add();
    }

    @Override
    public void update() {
        //日志操作
        log("update");
        userService.add();
    }

    @Override
    public void select() {
        //日志操作
        log("select");
        userService.add();
    }
    public void log(String msg){
        System.out.println("日志提示："+"执行了"+msg+"方法");
    }
}
class Client{
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        //代理角色
        UserProxy userProxy = new UserProxy();
        //使用代理类实现日志功能
        userProxy.setUserService(userServiceImpl);
        userProxy.add();
    }
}
