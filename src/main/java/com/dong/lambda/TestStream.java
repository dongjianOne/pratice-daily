package com.dong.lambda;

import org.assertj.core.util.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @Author DongJian
 * @Date Created in 2020/5/17 14:27
 * Utils: Intellij Idea
 * @Description: 常用的流操作
 * @Version:1.0
 */
public class TestStream {
    public static void main(String[] args) {
        //collect(Collectors.toList())--将流转化为List 类似的还有toMap toSet() 都属于及早求值
        List<Student> students = Stream.of(new Student("durant", 32, 208),
                new Student("curry", 33, 191)).collect(Collectors.toList());
        System.out.println(students);
        //filter--过滤筛选的功能，内部实现就是Predicate接口
        List<Student> studentList = Lists.newArrayList();
        Student kobe = new Student("kobe", 38, 198);
        Student curry = new Student("curry", 32, 191);
        Student durant = new Student("durant", 31, 208);
        studentList.add(kobe);
        studentList.add(curry);
        studentList.add(durant);
        //筛选掉身高低于195的学生
        studentList = studentList.stream().filter(s->s.getHight()>195).collect(Collectors.toList());
        System.out.println(studentList);
        //map -- 转换操作，内部实现的是Function接口，惰性求值
        List<String> mapStudentList = studentList.stream().map(s -> s.getName()).collect(Collectors.toList());
        System.out.println(mapStudentList);
        //flatMap -- 将多个Stream合并为一个Stream
        List<Student> flatMapStudents = Stream.of(studentList, asList(new Student("James", 36, 205), new Student("Harden", 31, 196))).flatMap(s -> s.stream()).
                collect(Collectors.toList());
        System.out.println(flatMapStudents);
        //max&min -- 求最值
        Optional<Student> maxHight = studentList.stream().max(Comparator.comparing(s -> s.getHight()));
        Optional<Student> minHight = studentList.stream().min(Comparator.comparing(s -> s.getHight()));
        // isPresent() --判断是否有值
        if (maxHight.isPresent()){
            System.out.println(maxHight.get());
        }
        if (minHight.isPresent()){
            System.out.println(minHight.get());
        }
        //count -- 统计功能 一般结合filter使用
        System.out.println(studentList.stream().count());
        //reduce --一组值中生出一个值，max、min、count都是reduce在操作
        Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, (a, b) -> (a + b));
        System.out.println(reduce);
        //collect --收集器 java.util.Stream.Collectors类静态导入到collect()
        Double avergAge = studentList.stream().collect(Collectors.averagingInt(s -> s.getAge()));
        System.out.println("平均年龄为："+avergAge);
        Student student = studentList.stream().collect(Collectors.maxBy(Comparator.comparing(s -> s.getHight()))).orElseGet(Student::new);
        System.out.println(student);

        //partitioningBy -- 接收一个Preidicate函数接口，实现分解成两个集合
        Map<Boolean, List<Student>> partitioningByMap = studentList.stream().collect(Collectors.partitioningBy(s -> s.getAge() > 32));
        System.out.println(partitioningByMap);
        //groupingBy -- 将数据进行分组
        Map<String, List<Student>> groupingByMap = studentList.stream().collect(Collectors.groupingBy(s -> s.getName()));
        System.out.println("groupingBy----"+groupingByMap);
        //joining -- 字符串的拼接
        String joinName = studentList.stream().map(s -> s.getName()).collect(Collectors.joining(",", "[", "]"));
        System.out.println("拼接后的名字----"+joinName);
        //去重
        studentList.add(new Student("kobe",25,200));
        System.out.println("去重前的集合----"+studentList);
        List<Student> duplicateList = studentList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() ->
                new TreeSet<>(Comparator.comparing(s -> s.getName()))), ArrayList::new));
        System.out.println("去重后的集合----"+duplicateList);
    }
}
