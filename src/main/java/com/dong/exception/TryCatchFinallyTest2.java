package com.dong.exception;

/**
 * @Author DongJian
 * @Date Created in 2020/6/12 15:45
 * Utils: Intellij Idea
 * @Description: finally执行时机探讨
 * @Version:1.0
 */
public class TryCatchFinallyTest2 {
    public static int total(){
        int i = 0;
        try {
            System.out.println("执行try:"+i);
            return i;//保留此处的值 先执行finally 若finally块没有返回值则将当前值返回
        } finally {
            ++i;
            System.out.println("执行finally:"+i);
        }
    }
    public static int total2(){
        int i = 0;
        try {
            System.out.println("执行try块:"+i);
            i = 1/0;//遇到异常先执行catch块，然后再执行finally
            return i;//保留此处的值 遇到异常先执行catch块,没有异常先执行finally块，若finally块有返回值则直接返回finally块的值
        } catch (Exception e) {
            ++i;
            System.out.println("执行catch块:"+i);
            return i;//保留此处的值 先执行finally块，若finally块有返回值则直接返回finally块的值
        } finally {
            ++i;
            System.out.println("执行finally块:"+i);
//            return i;
        }
    }
    public static void main(String[] args) {
        //输出结果 finally在return 之前执行
//        执行try
////        执行finally
////        11
        System.out.println(total());
        System.out.println("-------------------------");
        System.out.println(total2());

    }
}
