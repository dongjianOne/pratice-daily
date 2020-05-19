package com.dong.tryandcatch;

/**
 * @Author DongJian
 * @Date Created in 2020/5/19 9:27
 * Utils: Intellij Idea
 * @Description: try-with-resource--实现AutoCloseable接口并且重写了close方法
 * @Version:1.0
 */
public class TryWithResource implements AutoCloseable{

    private int age = 18;

    @Override
    public void close() throws Exception {
        System.out.println("this is close method");
    }

    public static void main(String[] args) {
        try(TryWithResource tryWithResource = new TryWithResource()) {
            System.out.println(tryWithResource.age);
        }catch (Exception e){
        }
    }
}
