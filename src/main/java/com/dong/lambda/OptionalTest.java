package com.dong.lambda;

import java.util.Optional;

/**
 * @Author DongJian
 * @Date Created in 2020/9/14 10:34
 * Utils: Intellij Idea
 * @Description: Optional类已经成为Java 8类库的一部分，在Guava中早就有了，可能Oracle是直接拿来使用了
 * Optional用来解决空指针异常，使代码更加严谨，防止因为空指针NullPointerException对代码造成影响
 * @Version:1.0
 */
public class OptionalTest {

    public static void main(String[] args) {
        // 为空则返回空Optional，否则返回一个指定值的Optional
        Optional<String> test = Optional.ofNullable("test");
        // .of 返回当前类
        Optional<String> optionalS = Optional.of("hello");
        // 判断是否有值，不为空
        boolean strFlag = optionalS.isPresent();
        // 若有值则返回，无值则报空指针异常
        String str = optionalS.get();
        // 若为空则返回else指定的值
        String hi = optionalS.orElse("hi");
        // ifPresent() 若值不为空则执行
        optionalS.ifPresent(opt -> System.out.println(opt));
    }
}
