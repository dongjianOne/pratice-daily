package com.dong.unified.controller;

import com.dong.stream.User;
import com.dong.unified.ServiceExceptionEnum;
import com.dong.unified.exception.ServiceException;
import com.dong.vo.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DongJian
 * @date Created in 2020/11/28 17:01
 * Utils: Intellij Idea
 * @description:
 * @version:1.0
 */
@RestController
public class testExceptionController {

    @GetMapping("exception-01")
    public CommonResult exception() {
        throw new NullPointerException("这是一个其他异常!");
    }

    @GetMapping("exception-02")
    public CommonResult serviceException() {
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }

    @GetMapping("exception-03")
    public CommonResult serviceException2() {
        throw new ServiceException("这是一个自定义业务异常",100001);
    }
}
