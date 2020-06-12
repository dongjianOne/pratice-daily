package com.dong.exception;

/**
 * @Author DongJian
 * @Date Created in 2020/6/12 15:26
 * Utils: Intellij Idea
 * @Description: 测试 finally一定会执行吗？
 * @Version:1.0
 */
public class TryCatchFinallyTest {
    public static int total() {
        int i = 11;
//        return 1/0;
//        if (i == 11) {
//            return i;
//        }
        //1.如果try都执行不了，finally块自然就执行不到
//        try {
//            System.out.println("执行try块");
//        } finally {
//            System.out.println("执行finally块");
//        }
        try {
            System.out.println("执行try块");
            //退出JVM 一般不要做这种操作
//            System.exit(0);
            //在try块中出现异常或者retrun finally都会执行
            int i1 = 1/0;
        }catch (Exception e){
            System.out.println("执行catch块");
        }finally {
            System.out.println("执行finally块");
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(total());
    }
}
