package com.dong.annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class mainTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> customClass = Class.forName("com.dong.annotation.CustomAnnotation");
//        Method[] methods = customClass.getMethods();
//        for (Method method : methods) {
//            Annotation[] annotations = method.getAnnotations();
//            for (Annotation annotation : annotations) {
//                MyAnnotation1 customAnnotation = (MyAnnotation1)annotation;
//                System.out.println(customAnnotation.value());
//            }
//        }
        List<Method> collect = Arrays.stream(customClass.getMethods()).filter(c -> c.isAnnotationPresent(MyAnnotation1.class)).collect(Collectors.toList());
        System.out.println(collect);
        /* Annotation[] annotations = customClass.getAnnotations();
        for (Annotation annotation : annotations) {
            MyAnnotation1 customAnnotation = (MyAnnotation1)annotation;
            System.out.println(customAnnotation.value());
        }*/
    }
}
