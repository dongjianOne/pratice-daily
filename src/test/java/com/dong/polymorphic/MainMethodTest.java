package com.dong.polymorphic;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author DongJian
 * @Date Created in 2020/7/14 17:43
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class MainMethodTest {
    @Autowired
    @Qualifier("dog")
    Dog dog;
    @Autowired
    @Qualifier("cat")
    Cat cat;
    @Test
    void animal() {
        System.out.println(dog.climbUp("dog"));
        System.out.println(cat.climbUp("cat"));
    }
}