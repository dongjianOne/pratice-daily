package com.dong.polymorphic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @Author DongJian
 * @Date Created in 2020/7/14 17:38
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class MainMethod {
    @Autowired
    @Qualifier("dog")
    Dog dog;
    @Autowired
    @Qualifier("cat")
    Cat cat;

     void animal(String name1,String name2){
         System.out.println(dog.climbUp(name1));
         System.out.println(cat.climbUp(name2));
     }

    public static void main(String[] args) {
        MainMethod m = new MainMethod();
        m.animal("dog","cat");
    }
}
