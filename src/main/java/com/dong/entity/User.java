package com.dong.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @Author DongJian
 * @Date Created in 2020/5/9 16:53
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
@Data
@Getter
@Setter
@Accessors(chain = true)
public class User {
    /**
     *  编号
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 年级
     */
    private String grade;
    /**
     * 经费
     */
    private BigDecimal balance;
    /**
     * 年龄
     */
    private Integer age;
}
