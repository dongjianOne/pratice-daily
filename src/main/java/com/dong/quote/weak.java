package com.dong.quote;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author DongJian
 * @Date Created in 2020/7/27 14:39
 * Utils: Intellij Idea
 * @Description: test 弱引用：无论内存是否充足，gc执行到则会被回收
 * 虚引用：如同虚设，跟没有引用一样，在回收之前会先加入到与之关联的引用队列
 * @Version:1.0
 */
public class weak {
    public static void main(String[] args) {

        Object ob = new Object();
        // 测试弱引用
        WeakReference<Object> wr = new WeakReference<Object>(ob);
        System.out.println("------------------ob gc before------------");
        System.out.println(ob);
        System.out.println(wr.get());
        // 对象设置为null，失去引用，方便GC
        ob = null;
        System.gc();
        System.out.println("---------------ob gc after----------------");
        System.out.println(ob);
        System.out.println(wr.get());

        // 需引用
        Object ob1 = new Object();
        // 引用队列
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
        // PhantomReference.class:虚引用类
        PhantomReference<Object> pr = new PhantomReference<Object>(ob1, referenceQueue);
        System.out.println("--------------------------ob1 gc before--------------------------");
        System.out.println(ob1);
        System.out.println(pr.get());
        // 对象置空，便于回收
        ob1 = null;
        System.gc();
        System.out.println("--------------------------ob1 gc after--------------------------");
        System.out.println(ob1);
        System.out.println(pr.get());

//        new ArrayList<String>().forEach();
    }
}
