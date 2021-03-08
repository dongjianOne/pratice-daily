package com.dong.test;

import java.time.LocalDateTime;

/**
 * <p>
 * 实现
 * </p>
 *
 * @author: dong
 * @Date: 11:23 2021/3/4
 */
public class LocalDateTest {

    public static void main(String[] args) {
        LocalDateTime startDateTime = LocalDateTime.of(2021, 03, 04, 8, 30, 00);
        LocalDateTime endDateTime = LocalDateTime.of(2021, 03, 04, 17, 30, 00);

        System.out.println(LocalDateTime.now().isAfter(startDateTime));
        System.out.println(LocalDateTime.now().isBefore(endDateTime));
    }
}
