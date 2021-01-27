package com.dong.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
}
