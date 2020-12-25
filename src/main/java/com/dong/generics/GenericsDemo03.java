package com.dong.generics;

public class GenericsDemo03 {

    public static void main(String[] args) {
        Demo demo = new Demo();
        Demo demo1 = new Demo();
        demo.fun("关羽");
        demo1.fun(1573);
        System.out.println(demo);
        System.out.println(demo1);
    }
}

class Demo {
    public <T> T fun(T t) {
        return t;
    }
}