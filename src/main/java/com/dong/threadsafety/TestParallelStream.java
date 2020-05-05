package com.dong.threadsafety;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author DongJian
 * @Date Created in 2020/4/15 23:56
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class TestParallelStream {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            integers.add(i);
        }
        List<Integer> integers1 = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            integers1.add(i);
        }
        integers.parallelStream().forEach(a->{
            for (Integer i : integers1){
                if (a==i){
                    System.out.println(a+"是我");
                }else {
                    System.out.println(a);
                }
            }
        });
        System.out.println(integers.size());
    }
}
