package com.dong.reflection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * <p>
 * 通过配置文件利用反射生成对象实例
 * </p>
 *
 * @author: dong
 * @Date: 17:16 2021/1/29
 */
public class GenerateClassByReflect {
    public static void main(String[] args) throws Exception{
        Properties prop = new Properties();
        // 读取配置文件
        prop.load(new FileReader("C:\\Users\\DJ\\Desktop\\class.txt"));
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        Class<?> aClass = Class.forName(className);
        Method method = aClass.getDeclaredMethod(methodName);
        method.invoke(aClass.newInstance());
    }
}
