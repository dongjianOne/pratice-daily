package com.dong.generics;

/**
 * @return
 * @Description 通配符 ?
 * @Author dongjian 2020/12/25 14:24
 * @Param
 **/
public class GenericsDemo02 {


    public static void main(String[] args) {

        Info<String> info = new Info<>();
        info.setVar("刘备");
        fun(info);
    }

    public static void fun(Info<?> var) {
        System.out.println("对象内容：" + var);
    }
}

class Info<T> {
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