package com.dong.exception.exceptionadvice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author DongJian
 * @Date Created in 2020/8/5 13:43
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
@RestController
@Api("参数校验")
public class UserController {

    /**
     * @return java.lang.String
     * @Description BindingResult
     * @Author dongjian 2020/8/5 13:59
     * @Param [user, bindResult]
     **/
    @ApiOperation("Validator参数校验")
    @GetMapping("/test-validator-bindResult")
    public String addUser(@RequestBody @Valid User user, BindingResult bindResult){
        // 返回校验信息
        for (ObjectError objectError : bindResult.getAllErrors()){
            return objectError.getDefaultMessage();
        }
        return "SUCCESS";
    }
    /**
     * @return java.lang.String
     * @Description 去掉BindingResult 自动抛出异常
     * @Author dongjian 2020/8/5 14:03
     * @Param [user]
     **/
    @ApiOperation("Validator参数校验")
    @GetMapping("/test-validator-nobindResult")
    public String addUser1(@RequestBody @Valid User user){

        return "SUCCESS";
    }

    @ApiOperation("数据统一响应返回体")
    @GetMapping("/test-result")
    public ResultVO<User> getUser(@RequestBody @Valid User user) {
        return new ResultVO<>(user);
    }
}
