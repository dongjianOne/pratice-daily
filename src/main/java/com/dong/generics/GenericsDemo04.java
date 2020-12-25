package com.dong.generics;

import io.swagger.models.auth.In;

public class GenericsDemo04 {

    public static void main(String[] args) {
        Info1<Integer> fun = fun(30);
        System.out.println(fun.getVar());
    }

    public static <T extends Number> Info1<T> fun(T var) { // 方法中传入或返回的类型由调用方定义的类型决定
        Info1<T> info1 = new Info1<>(); // 根据传入的类型实例化info1
        info1.setVar(var);
        return info1;
    }

}

class Info1<T extends Number> {
    private T var;

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return this.var;
    }

    public String toString() { // 打印
        return this.var.toString();
    }
}


