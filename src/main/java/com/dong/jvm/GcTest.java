package com.dong.jvm;

/**
 * @Author DongJian
 * @Date Created in 2020/6/23 13:35
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class GcTest {
    public static void main(String[] args) {
        if (true){
            byte[] placeHolder = new byte[64 * 1024 * 1024];
            System.out.println(placeHolder.length /1024);
            placeHolder = null;
        }
        //调用gc()
        System.gc();
    }
}
