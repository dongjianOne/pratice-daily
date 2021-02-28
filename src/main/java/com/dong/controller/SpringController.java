package com.dong.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype") // controller默认是单例，这里利用@Scope注解将其设置多例
public class SpringController {

    /**
     * 切记不要在Controller层定义非静态成员变量
     */
    public Integer num = 0;

    @GetMapping(value = "/controller1")
    public void controller1 () {
        System.out.println(++num);
    }

    @GetMapping(value = "/controller2")
    public void controller2 () {
        System.out.println(++num);
    }
}
