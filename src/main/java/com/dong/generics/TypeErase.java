package com.dong.generics;

import io.micrometer.core.instrument.util.StringEscapeUtils;
import org.apache.commons.codec.binary.BaseNCodec;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 类型擦除,编译阶段有T，在运行阶段<T>会被替换成<Object或指定的上限>(JVM)
 * </p>
 *
 * @author: dong
 * @Date: 15:39 2021/2/1
 */
public class TypeErase {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        // 运行阶段类型擦除
        System.out.println(stringList.getClass() == integerList.getClass()); // true
        //
        System.out.println(URLDecoder.decode("T %2b 0"));

    }
}
