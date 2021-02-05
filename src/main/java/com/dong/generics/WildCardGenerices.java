package com.dong.generics;

import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author DongJian
 * @Date Created in 2020/7/24 10:57
 * Utils: Intellij Idea
 * @Description: ?-类型通配符 可以匹配任意类型
 * 注意：只能调用对象与类型无关的方法，不能调用与类型有关的的方法，因为知道外界使用的时候才能知道具体的类型是什么
 * @Version:1.0
 */
@Slf4j
public class WildCardGenerices {

    /**
     * @return void
     * @Description 类型通配符
     * @Author dongjian 2020/7/24 10:58
     * @Param [list]
     **/
    public void testWildCard1(List<?> list) {
        list.forEach(l -> {
            System.out.println(l);
        });
    }

    /**
     * @return void
     * @Description 设定通配符上限
     * @Author dongjian 2020/7/24 11:09
     * @Param [list-传入集合]
     **/
    public void testWildCard2(List<? extends Number> list) {
        list.forEach(l -> {
            System.out.println(l);
        });
    }

    /**
     * @return void
     * @Description 泛型方法
     * @Author dongjian 2020/7/24 11:39
     * @Param [t]
     **/
    public <T> void show(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        WildCardGenerices wg = new WildCardGenerices();
        System.out.println("--------------------------------testWildCard1---------------------------------------");
        // String类型list
        List<String> list1 = Lists.newArrayList();
        list1.add("dongjian");
        wg.testWildCard1(list1);
        // Integer类型list
        List<Integer> list2 = Lists.newArrayList();
        list2.add(666);
        wg.testWildCard1(list2);
        System.out.println("--------------------------------testWildCard2---------------------------------------");
        // Number类型内数据
        List<Integer> list3 = Lists.newArrayList();
        list3.add(888);
        wg.testWildCard2(list3);
        // Number类型外数据
        List<String> list4 = Lists.newArrayList();
        list4.add("libai");
        // wg.testWildCard2(list4); 编译报错

        System.out.println("--------------------------------show---------------------------------------");
        // 字符串
        wg.show("dong");
        // 数字
        wg.show(2020);
        System.out.println("---------------------------------泛型与通配符 总结：--------------------------------------");
        System.out.println("如果参数类型之间有依赖关系或者返回值与参数有依赖关系，选择泛型方法");
        System.out.println("如果不存在依赖关系，则选择通配符，通配符更加灵活");
        // ------------------------------泛型只在编译期有效------------------------------------------------------
        List<String> stringList = Lists.newArrayList();
        List<Integer> integerList = Lists.newArrayList();
        Class<? extends List> aClass = stringList.getClass();
        Class<? extends List> bClass = integerList.getClass();
        if (aClass.equals(bClass)) {
            System.out.println("类型相同");
        }

//        new ArrayList<String>().forEach();

        List<?> list = Lists.newArrayList();
//        list.add("10"); // 报错，？类型未知
    }
}
