package com.dong.utils;


import org.junit.platform.commons.util.StringUtils;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 实现
 * </p>
 *
 * @author: dong
 * @Date: 14:08 2021/1/27
 */
public class EncryptUtils {

    /**
     * 身份证前三后四脱敏
     */
    public static String idEncrypt(String id) {
        if (ObjectUtils.isEmpty(id) || (id.length() < 8)) {
            return id;
        }
        return id.replaceAll("(?<=\\w{3})\\w(?=\\w{4})", "*");
    }

    /**
     * 手机号码前三后四脱敏
     */
    public static String mobileEncrypt(String mobile) {
        if (ObjectUtils.isEmpty(mobile) || (mobile.length() != 11)) {
            return mobile;
        }
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }
    public static void main(String[] args) {
        // 身份证
        System.out.println("身份证前三后四脱敏："+ idEncrypt("159898199502262713"));
        // 手机号
        System.out.println("手机号码前三后四脱敏: " + mobileEncrypt("15321826060"));
    }
}
