package com.dong.stream;

import lombok.Data;

/**
 * @version 1.0
 * @author:dongjian
 * @date:2020/10/8 0008
 * @describe:
 */
@Data
public class User {

    private int num;
    private String name;
    private String city;
    private String information;

    public User() {

    }

    public User(int num, String name, String city, String information) {
        this.num = num;
        this.name = name;
        this.city = city;
        this.information = information;
    }
}
