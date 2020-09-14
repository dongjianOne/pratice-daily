package com.dong.threadlocal;

import java.lang.reflect.Field;

/**
 * @Author DongJian
 * @Date Created in 2020/9/4 15:31
 * Utils: Intellij Idea
 * @Description: 测试 ThreadLocal Key是否在gc的操作时被回收
 * @Version:1.0
 */
public class ThreadLocalDemo {


        public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
            Thread t = new Thread(()->test("abc",false));
            t.start();
            t.join();
            System.out.println("--gc后--");
            Thread t2 = new Thread(() -> test("def", true));
            t2.start();
            t2.join();
        }

        private static void test(String s,boolean isGC)  {
            try {
                // 强引用 不会被回收
                ThreadLocal<Object> threadLocal = new ThreadLocal<>();
                threadLocal.set(s);
                if (isGC) {
                    System.gc();
                }
                Thread t = Thread.currentThread();
                Class<? extends Thread> clz = t.getClass();
                Field field = clz.getDeclaredField("threadLocals");
                field.setAccessible(true);
                Object threadLocalMap = field.get(t);
                Class<?> tlmClass = threadLocalMap.getClass();
                Field tableField = tlmClass.getDeclaredField("table");
                tableField.setAccessible(true);
                Object[] arr = (Object[]) tableField.get(threadLocalMap);
                for (Object o : arr) {
                    if (o != null) {
                        Class<?> entryClass = o.getClass();
                        Field valueField = entryClass.getDeclaredField("value");
                        Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                        valueField.setAccessible(true);
                        referenceField.setAccessible(true);
                        System.out.println(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
