package com.dong.test;

import lombok.Data;
import org.assertj.core.util.Lists;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class StringTest {

    public static void main(String[] args) {
//        Date from = Date.from(LocalDate.now().plusDays(1L).atStartOfDay(ZoneId.systemDefault()).toInstant());

        // 精度丢失
//        System.out.println(0.1+0.2);
//        System.out.println(4.015*100);
//        // BigDecimal
//        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.2)));
//        System.out.println(new BigDecimal(1.0).subtract(new BigDecimal(0.8))); // 减
//        System.out.println(new BigDecimal(4.015).multiply(new BigDecimal(100))); // 乘
//        System.out.println(new BigDecimal(123.16).divide(new BigDecimal(100)));// 除
//
//        // BigDecimal来表示和计算浮点数的时候，要使用String的构造方法来初始化BigDecimal。
//        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));
//        System.out.println(new BigDecimal("1.0").subtract(new BigDecimal("0.8"))); // 减
//        System.out.println(new BigDecimal("4.015").multiply(new BigDecimal("100"))); // 乘
//        System.out.println(new BigDecimal("123.16").divide(new BigDecimal("100")));// 除
//
//        // ---------------------------------------------------------
//        BigDecimal b1 = new BigDecimal(Double.toString(100d));
//        BigDecimal b2 = new BigDecimal(String.valueOf(100));
//        BigDecimal b3 = BigDecimal.valueOf(100d);
//        new BigDecimal("100");
        List<Task> tasks = Lists.newArrayList();
        Task task = new Task();
        task.setUserCode1("a");
        task.setUserCode2("b");
        Task task1 = new Task();
        task1.setUserCode1("b");
        task1.setUserCode2("c");
        Task task2 = new Task();
        task2.setUserCode1("c");
        task2.setUserCode2("d");
        Task task3 = new Task();
        task3.setUserCode1("x");
        task3.setUserCode2("y");
        tasks.add(task);
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        List<String> userCodes1 = tasks.stream().map(t -> t.getUserCode1()).collect(Collectors.toList());
        List<String> userCodes2 = tasks.stream().map(t -> t.getUserCode2()).collect(Collectors.toList());
        Map<String, String> userCode1Map = tasks.stream().collect(Collectors.toMap(t1 -> t1.getUserCode1(), t2 -> t2.getUserCode2(), (k1, k2) -> k1));
        Map<String, String> userCode2Map = tasks.stream().collect(Collectors.toMap(t1 -> t1.getUserCode2(), t2 -> t2.getUserCode1(), (k1, k2) -> k1));
        //a->b
        //b->c
        //c->d
        AtomicReference<String> s = new AtomicReference<>("");
        s.set(tasks.get(0).getUserCode1()+"->"+tasks.get(0).getUserCode2());
        tasks.stream().forEach( t-> {
            userCodes1.remove(t.getUserCode1());
            userCodes2.remove(t.getUserCode2());
            if (userCodes2.contains(t.getUserCode1())) {
                s.set(userCode2Map.get(t.getUserCode1()) + "->" + t.getUserCode1());
            }
            if (userCodes1.contains(t.getUserCode2())) {
                s.set(s + "->" + userCode1Map.get(t.getUserCode2()));
            }
        });

        System.out.println(s);
    }




}

@Data
class Task {
    private String userCode1;
    private String userCode2;
}
