package com.dong.polymorphic;

import org.springframework.stereotype.Service;

/**
 * @Author DongJian
 * @Date Created in 2020/7/14 17:37
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
@Service("cat")
public class Cat implements Behavior {
    @Override
    public String climbUp(String name) {
        return name+": 我也在爬树!";
    }
}
