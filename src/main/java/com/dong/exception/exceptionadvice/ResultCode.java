package com.dong.exception.exceptionadvice;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * @Author DongJian
 * @Date Created in 2020/8/5 15:13
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
@Getter
public enum ResultCode implements Serializable{

    SUCCESS(1000, "操作成功"),

    FAILED(1001, "响应失败"),

    VALIDATE_FAILED(1002, "参数校验失败"),

    ERROR(5000, "未知错误");

    private int code;

    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
