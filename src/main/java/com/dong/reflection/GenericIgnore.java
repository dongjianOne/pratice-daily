package com.dong.reflection;

import org.assertj.core.util.Lists;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 反射略过泛型检查
 * </p>
 *
 * @author: dong
 * @Date: 17:51 2021/1/29
 */
public class GenericIgnore {

    public static void main(String[] args) throws Exception {
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

//        list.add("dong"); 类型检查编译不通过

        // 反射实现
        Class<? extends List> listClass = list.getClass();
        Method addMethod = listClass.getDeclaredMethod("add", Object.class);
        addMethod.invoke(list, "dong");

        System.out.println(list);
    }
}
