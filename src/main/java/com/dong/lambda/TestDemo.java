package com.dong.lambda;

/**
 * @Author DongJian
 * @Date Created in 2020/3/29 18:09
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class TestDemo {
    // 2.静态内部类
    static class Like2 implements Ilike{

        @Override
        public void lambda() {
            System.out.println("I like lambda2 !");
        }
    }

    public static void main(String[] args) {
        // 3.局部内部类:在一个类的成员方法中的类，只能访问被final修饰的局部变量
        class Like3 implements Ilike{

            @Override
            public void lambda() {
                System.out.println("I like lambda3 !");
            }
        }

        new Like().lambda();
        new Like2().lambda();
        new Like3().lambda();
        // 4.匿名内部类 ：没有类的名称，只能借助接口或者父类
        new Ilike(){
            @Override
            public void lambda() {
                System.out.println("I like lambda4 !");
            }
        }.lambda();
        Ilike like = ()->{
            System.out.println("I like lambda5 !");
        };
        like.lambda();
    }



}
interface Ilike{
    void lambda();
}

class Like implements Ilike{

    @Override
    public void lambda() {
        System.out.println("I like lambda !");
    }
}