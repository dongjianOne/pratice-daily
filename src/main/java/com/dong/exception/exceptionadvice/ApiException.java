package com.dong.exception.exceptionadvice;

import lombok.Getter;

/**
 * @Author DongJian
 * @Date Created in 2020/8/5 14:41
 * Utils: Intellij Idea
 * @Description: 自定义异常
 * @Version:1.0
 */
@Getter
public class ApiException extends RuntimeException {

    private String code;
    private String msg;

    public ApiException() {
        // 这里可替换成枚举
        this("10001", "接口错误");
    }

    public ApiException(String msg) {
        this("10001",msg);
    }

    public ApiException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
