package com.dong.utils;

import org.springframework.util.AntPathMatcher;

/**
 * <p>
 * 实现
 * </p>
 *
 * @author: dong
 * @Date: 15:57 2021/3/10
 */
public class PathMatcher {

    public static final String IGNORE_URL = "**/igonre/**";
    static final AntPathMatcher pathMatcher = new AntPathMatcher();
    public static void main(String[] args) {
        System.out.println(pathMatcher.match(IGNORE_URL, "a/igonre/b"));
    }
}
