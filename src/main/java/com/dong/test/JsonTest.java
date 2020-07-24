package com.dong.test;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author DongJian
 * @Date Created in 2020/7/21 10:11
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
@Slf4j
public class JsonTest {

    public static void main(String[] args) {
        final Gson json = new Gson();
        System.out.println("before toJson"+Arrays.asList("dong", "jian"));
        System.out.println("Test Gson"+json.toJson(Arrays.asList("dong", "jian","hello")));
    }

}
