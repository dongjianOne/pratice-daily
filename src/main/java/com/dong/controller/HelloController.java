package com.dong.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author DongJian
 * @Date Created in 2020/5/2 0:29
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
