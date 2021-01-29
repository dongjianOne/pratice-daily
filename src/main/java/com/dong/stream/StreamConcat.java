package com.dong.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 合并流
 * </p>
 *
 * @author: dong
 * @Date: 14:36 2021/1/27
 */
public class StreamConcat {

    public static void main(String[] args) {
        Stream<String> firstStream = Stream.of("1", "2");
        Stream<String> secondStream = Stream.of("2", "3");

//        List<String> list = Stream.concat(firstStream, secondStream).collect(Collectors.toList());
//        System.out.println("合并后的数据：" + list);

        // 合并并去重
        List<String> disList = Stream.concat(firstStream, secondStream).distinct().collect(Collectors.toList());
        System.out.println("合并并去重后数据:" + disList);
    }
}
