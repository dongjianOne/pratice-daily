package com.dong.collection;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author DongJian
 * @date Created in 2020/10/22 13:56
 * Utils: Intellij Idea
 * @description: CopyOnWriteList-迭代器的弱一致性
 * @version:1.0
 */
public class CopyOnWriteListTest {

    public static void main(String[] args) {
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("hello");
        copyOnWriteArrayList.add("你好");
        // 获取迭代器
        Iterator<String> iterator = copyOnWriteArrayList.iterator();

        // 再次新增元素
        copyOnWriteArrayList.add("小明");

        // 输出数据
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);// 拿到迭代器之后元素的更新不可见
        }
    }

}
