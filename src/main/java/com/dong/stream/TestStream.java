package com.dong.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author DongJian
 * @Date Created in 2020/7/28 17:00
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class TestStream {
    public static void main(String[] args) {
        System.out.println("------------------limit()-------------------------------");
        System.out.println(Arrays.toString(IntStream.range(1, 5).limit(4).toArray()));
        System.out.println("------peek():生成一个包含原Stream所有元素的新Stream并提供一个消费函数------------------");
        Arrays.asList(IntStream.range(1, 5).peek(x -> System.out.print(x)).toArray());
        System.out.println("--skip:返回一个丢弃原Stream前N个元素剩下元素组成的新Stream，若原Stream元素个数小于N则返回空Stream--");
        System.out.println(Arrays.toString(IntStream.range(1, 5).skip(2).limit(4).toArray()));
    }
}
