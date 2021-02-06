package com.dong.sqlmapper;

import java.util.Locale;
import java.util.stream.Stream;


/**
 * @author DJ
 * Mybatis get-set方法获取属性的源码
 */
public final class PropertyNamer {

    private PropertyNamer() {
        // Prevent Instantiation of Static Class
    }

    public static String methodToProperty(String name) {
        if (name.startsWith("is")) {//is开头的一般是bool类型，直接从第二个(索引)开始截取(简单粗暴)
            name = name.substring(2);
        } else if (name.startsWith("get") || name.startsWith("set")) {//set-get的就从第三个(索引)开始截取
            name = name.substring(3);
        } else {
//            throw new ReflectionException("Error parsing property name '" + name + "'.  Didn't start with 'is', 'get' or 'set'.");
        }
        //下面这个判断很重要，可以分成两句话开始解释，解释如下
        //第一句话：name.length()==1
        // 对于属性只有一个字母的，例如private int x;
        // 对应的get-set方法是getX();setX(int x);
        //第二句话：name.length() > 1 && !Character.isUpperCase(name.charAt(1)))
        //      属性名字长度大于1，并且第二个(代码中的charAt(1)，这个1是数组下标)字母是小写的
        //      如果第二个char是大写的，那就直接返回name
        if (name.length() == 1 || (name.length() > 1 && !Character.isUpperCase(name.charAt(1)))) {
            name = name.substring(0, 1).toLowerCase(Locale.ENGLISH) + name.substring(1);//让属性名第一个字母小写，然后加上后面的内容
        }

        return name;
    }

    public static boolean isProperty(String name) {
        return name.startsWith("get") || name.startsWith("set") || name.startsWith("is");
    }

    public static boolean isGetter(String name) {
        return name.startsWith("get") || name.startsWith("is");
    }

    public static boolean isSetter(String name) {
        return name.startsWith("set");
    }

    // 测试
    public static void main(String[] args) {
//        String isName = "isName";
//        String getName = "getName";
//        String getnMetaType = "getnMetaType";
//        String getNMetaType = "getNMetaType"; isName, getName, getnMetaType, getNMetaType,
        String getX = "getX";
        Stream.of(getX).forEach(methodName ->
                System.out.println(methodToProperty(methodName))
        );
    }
}

class UClass {
    private String className;
    private String classId;
}
