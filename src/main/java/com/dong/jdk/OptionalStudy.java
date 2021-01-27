package com.dong.jdk;


import com.dong.entity.User;
import org.assertj.core.util.Lists;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * learn Optional
 */
public class OptionalStudy {

    public static void main(String[] args) {
        Optional<User> optionalUser = Optional.empty();
//        System.out.println(optionalUser.get());

        // of()
        // Optional<User> ofUser = Optional.of(null); // NullPointerException报错

        // ofNullable()
        Optional<Object> ofNullableUser = Optional.ofNullable(null); // 不会抛出NPE
        // ofNullableUser.get();// NPE

        // isPresent() 判断可选值是否为空
        boolean present = ofNullableUser.isPresent();
        System.out.println(present); // false

        // isPresent(Consumer<? super T> consumer) 判空同时非空时执行函数式操作
        User user = new User();
        Optional<User> user1 = Optional.ofNullable(user);
        // 如果不为空 则可根据消费者入参执行
        user1.ifPresent(u -> u.setId("1"));
        System.out.println(user);


        // orElse():如果对象为空则返回默认值，不为空则忽略默认值
        User user2 = new User().setName("user2");
        Optional.ofNullable(user2).orElse(createNewUser("orElse"));
        System.out.println("orElse() orElseGet() 返回默认值:" + user2.getName().endsWith("user2"));
        // 若对象不为空则取A，为空取B Optional.ofNullable(A).orElseGet(B)
        // orElseGet(Supplier<? extends T> other)  有值的时候返回值 没值则执行入参内容
        Optional.ofNullable(user2).orElseGet(() -> createNewUser("orElseGet"));

        // orElseThrow() 对象为空则抛出异常
//        Optional.ofNullable(null).orElseThrow(RuntimeException::new);


        // map 若不为空则取一个属性值，若对象或者属性值为空则返回默认值
        user.setName("dongjian");
        String default_name = Optional.ofNullable(user).map(User::getName).orElseGet(()->"Default name");
        System.out.println(default_name);

        // 对象不为空 且满足filter条件则返回对象，否则抛出异常
        User d = Optional.ofNullable(user).filter(u -> u.getName().equals("dongjian")).orElseThrow(RuntimeException::new);
        System.out.println(d);
    }

    /**
     * 创建一个新对象
     * @return
     */
    private static User createNewUser(String name) {
        System.out.println(name + "执行了。。。");
        return new User().setName("createUser");
    }

}
