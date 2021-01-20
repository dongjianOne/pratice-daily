package com.dong.test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.assertj.core.util.Lists;
import org.junit.platform.commons.util.StringUtils;

import javax.swing.text.DateFormatter;
import java.text.Collator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
public class TestLocalDate {

    public static void main(String[] args) {
//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
//
//
//        List<String> stringList = Lists.newArrayList();
//        List<String> stringList1 = Lists.newArrayList();
//        stringList.addAll(stringList1);
//        System.out.println(stringList);
//
//        String format1 = LocalTime.parse("00:55").format(DateTimeFormatter.ofPattern("HH:mm:ss"));
//        System.out.println(format1);
//        LocalDateTime startTime = LocalDateTime.of(LocalDate.parse("2020-12-24"), LocalTime.parse(format1));
//        System.out.println(startTime);

//        System.out.println(LocalDateTime.now().plusDays(1));


//        System.out.println(LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.parse("04:00:00")));
        // 判断两个时间是否是同一天
//        System.out.println(LocalDateTime.now().isEqual(LocalDateTime.now()));
//        LocalDate localDate = LocalDate.of(2020, 12, 31);
//        LocalDateTime currentTime = LocalDateTime.of(localDate, LocalTime.parse("09:00:00"));
//        System.out.println(currentTime.toLocalDate());
//        System.out.println(currentTime.toLocalDate().isEqual(LocalDate.now()));
//        System.out.println(System.currentTimeMillis());
//        LocalDate date = LocalDate.now();
//        long mili = date.atStartOfDay().toInstant(ZoneOffset.of("+8")).toEpochMilli();

//        System.out.println(mili);
        // 上一次该任务负责人
//            String lastHolderCode = "p1";
//            String lastHolderUserCode = "";
//            if (StringUtils.isNotBlank(lastHolderCode)) {
//                String[] split = lastHolderCode.split("-");
//                int i = Arrays.asList(split).lastIndexOf("p3");
//                if (i >= 1) {
//                    lastHolderUserCode = split[i - 1];
//                }
//            }
//        }
//        List<User> list = Lists.newArrayList();
//        User u1 = new User();
//        User u2 = new User();
//        User u3 = new User();
//        User u4 = new User();
//        u1.setName("曹操");
//        u3.setName("关羽");
//        u2.setName("刘备");
//        u4.setName("a");
//        list.add(u1);
//        list.add(u2);
//        list.add(u3);
//        list.add(u4);
//        sortByChinese(list);
//        System.out.println(list);

        String b = test("c-d-a-b");
        System.out.println("b**"+b);
    }
    /**
     * @return void
     * @Description 中文排序
     * @Param [users]
     **/
    static void sortByChinese(List<User> users) {
        final Collator collator = Collator.getInstance(Locale.CHINESE);
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return collator.compare(o1.getName(), o2.getName());
            }
        });
    }
    static String test(String str) {
        List<String> strList = null;
        try {
            List<String> strings = Arrays.asList(str.split("-"));
            strList= new ArrayList<>(strings);
            strList.remove(strList.size()-1);
            strList.remove(strList.size()-1);
            str = String.join("-",strList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{},交接流程更新失败",str);
            // 若出错返回原交接流程
            return str;
        }
        return str;
    }
}
@Data
class User {
    private String name;
    private Integer age;
}
