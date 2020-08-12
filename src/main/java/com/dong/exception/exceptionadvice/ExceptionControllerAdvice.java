package com.dong.exception.exceptionadvice;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author DongJian
 * @Date Created in 2020/8/5 14:07
 * Utils: Intellij Idea
 * @Description: 全局异常
 * @Version:1.0
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {
    /**
     * @return java.lang.String
     * @Description MethodArgumentNotValidException
     * @Author dongjian 2020/8/5 14:26
     * @Param [e]
     **/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, error.getDefaultMessage());
    }

    /**
     * @return java.lang.String
     * @Description 自定义异常 但是只返回了msg 并没有返回code
     * @Author dongjian 2020/8/5 14:51
     * @Param [e]
     **/
    @ExceptionHandler(ApiException.class)
    public ResultVO<String> apiExceptionHander(ApiException e) {
        return new ResultVO<>(ResultCode.FAILED, e.getMsg());
    }
}
