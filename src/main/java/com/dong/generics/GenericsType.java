package com.dong.generics;

/**
 * @Author DongJian
 * @Date Created in 2020/5/25 16:23
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class GenericsType<T> {
    private T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public static void main(String[] args) {
        GenericsType<String> genericsType = new GenericsType<String>();
        genericsType.setType("apple");
        System.out.println(genericsType.getType());
    }
}
