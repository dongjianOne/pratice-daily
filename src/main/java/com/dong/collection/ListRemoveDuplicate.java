package com.dong.collection;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * @author DongJian
 * @date Created in 2020/11/19 9:26
 * Utils: Intellij Idea
 * @description: list集合元素去重:LinkedHashSet能达到去重和保持添加到set中的元素顺序
 * @version:1.0
 */
public class ListRemoveDuplicate {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = Lists.newArrayList(Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5, 6, 7));
        System.out.println("numberList去重前:" + numberList);
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(numberList);
        ArrayList<Integer> list = Lists.newArrayList(hashSet);
        System.out.println("numberList去重后:" + list);
    }
}
