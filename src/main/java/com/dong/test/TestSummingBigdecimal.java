package com.dong.test;

import com.dong.entity.User;
import com.dong.utils.SummingUtil;
import org.assertj.core.util.Lists;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * <p>
 * 实现
 * </p>
 *
 * @author: dong
 * @Date: 16:44 2021/3/15
 */
public class TestSummingBigdecimal {
    public static void main(String[] args) {
        User u1 = new User();
        u1.setGrade("1");
        u1.setBalance(BigDecimal.valueOf(100L));
        User u2 = new User();
        u2.setGrade("1");
        u2.setBalance(BigDecimal.valueOf(200L));
        User u3 = new User();
        u3.setGrade("1");
        u3.setBalance(BigDecimal.valueOf(200L));
        List<User> userList = Lists.newArrayList();
        User u4 = new User();
        u4.setGrade("1");
        u4.setBalance(new BigDecimal("100.011111"));
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        Map<String, BigDecimal> map = userList.stream().collect(groupingBy(u -> u.getGrade(), SummingUtil.summingBigDecimal(o -> o.getBalance())));
        System.out.println(map);
    }
}
