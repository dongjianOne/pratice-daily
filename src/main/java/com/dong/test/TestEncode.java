package com.dong.test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
//        List<String> list = null;
//        list.stream().forEach(s -> {
//            System.out.println(s);
//        });
        String fixedCatalog = "gzqh";
        String path = String.join(File.separator, fixedCatalog, LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(path);
    }
}
