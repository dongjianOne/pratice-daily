package com.dong.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DongJian
 * @date Created in 2020/11/27 18:16
 * Utils: Intellij Idea
 * @description:
 * @version:1.0
 */
@RestController
public class TestController11 {

    @GetMapping("test11")
    public String test(@RequestParam String name) {
        return name;
    }
}
