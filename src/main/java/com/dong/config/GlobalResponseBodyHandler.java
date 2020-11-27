package com.dong.config;

import com.dong.vo.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author DongJian
 * @date Created in 2020/11/27 18:01
 * Utils: Intellij Idea
 * @description:
 * @version:1.0
 */
@ControllerAdvice(basePackages = "com.dong.controller.HelloController") //指定包
public class GlobalResponseBodyHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true; //拦截所有的API返回结果
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 如果已经是统一的返回体则直接返回
        if (o instanceof CommonResult) {
            return o;
        }
        return CommonResult.success(o);
    }
}
