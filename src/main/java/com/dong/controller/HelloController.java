package com.dong.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public String hello(@RequestBody List<User> list){
        System.out.println(list);
        return "hello";
    }
}
