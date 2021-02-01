package com.dong.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;

/**
 * 前端入参转义字符
 */
public class UtfCodeTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String aaa = URLDecoder.decode("dongjian///","utf-8");
        System.out.println(aaa);
    }
}
