package com.dong.exception.exceptionadvice;

import lombok.Data;
import lombok.Getter;

/**
 * @Author DongJian
 * @Date Created in 2020/8/5 14:57
 * Utils: Intellij Idea
 * @Description: 数据统一响应返回体
 * @Version:1.0
 */
@Getter
public class ResultVO<T> {
    /**
     * 编码
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
