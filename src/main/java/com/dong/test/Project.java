package com.dong.test;

import lombok.Data;

import java.util.List;

/**
 * @Author DongJian
 * @Date Created in 2020/7/30 15:00
 * Utils: Intellij Idea
 * @Description: 用于验证@Data equal hashCode及toString方法 出现堆栈溢出
 * @Version:1.0
 */
@Data
public class Project {
    private int id;
    private String name;
    private List<Project> projects;

}
