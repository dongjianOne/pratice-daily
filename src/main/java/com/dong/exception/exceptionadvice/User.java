package com.dong.exception.exceptionadvice;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author DongJian
 * @Date Created in 2020/8/5 13:36
 * Utils: Intellij Idea
 * @Description: Validator注解进行参数校验
 * @Version:1.0
 */
@Data
public class User {

    @NotNull(message = "用户ID不为空")
    private Long id;

    @NotNull(message = "用户账号不能为空")
    @Size(min = 6, max = 11, message = "账号长度必须是6-11个字符")
    private String account;

    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 16, message = "密码长度必须是6-16个字符")
    private String passWord;

    @NotNull(message = "用户邮箱不能为空")
    @Email(message = "用户邮箱格式不准确")
    private String email;
}
