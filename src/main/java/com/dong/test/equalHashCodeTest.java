package com.dong.test;

import java.util.Arrays;

/**
 * @Author DongJian
 * @Date Created in 2020/7/30 14:59
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class equalHashCodeTest {

    public static void main(String[] args) {
        Project project = new Project();
        // 循环依赖
        project.setProjects(Arrays.asList(project));
        System.out.println("project--"+project.hashCode());
    }
}
