package com.dong.test;

import org.assertj.core.util.Lists;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 实现
 * </p>
 *
 * @author: dong
 * @Date: 14:37 2021/2/2
 */
public class TestEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        System.out.println(URLEncoder.encode("+","utf-8"));
        List<String> list = null;
        list.stream().forEach(s -> {
            System.out.println(s);
        });
    }
}
