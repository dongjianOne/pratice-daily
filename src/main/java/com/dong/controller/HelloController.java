package com.dong.controller;

import com.dong.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public String hello(@RequestBody List<User> list) {
        System.out.println(list);
        return "hello";
    }

    @GetMapping("param/{id}")
    public User test(@PathVariable String id) {
        User user = new User();
        user.setId(id);
        user.setName("曹操");
        return user;
    }

    @GetMapping("hello1")
    public List<String> hello1() {
        List<String> list = Arrays.asList("曹操", "刘备");
        return list;
    }
}
