package com.dong.test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * 实现
 * </p>
 *
 * @author: dong
 * @Date: 11:08 2021/2/22
 */
public class TestSplit {
    public static void main(String[] args) throws UnsupportedEncodingException, ParseException {
//        String str = "/gpzh/国泰君安期货/abc.txt";
//        System.out.println(Arrays.asList(str.split("/")));
//        System.out.println(str.split("/")[1]);


        BigDecimal b1 = BigDecimal.ZERO;
//        BigDecimal b2 = BigDecimal.ONE;
//        BigDecimal subtractResult = Optional.ofNullable(b1).orElse(BigDecimal.ZERO).subtract(Optional.ofNullable(b2).orElse(BigDecimal.ZERO));
//        System.out.println(subtractResult)

        /*StringBuilder sb = new StringBuilder(); // 线程不安全
        IntStream.range(1,10).forEach(i->{
            sb.append(i+"");
            if( i < 10){
                sb.append(",");
            }
        });
        System.out.println(sb);
        StringJoiner sj = new StringJoiner(",");
        IntStream.range(1,10).forEach(i -> {
            sj.add(i + "");
        });
        System.out.println(sj);*/

        /*System.out.println(String.join("", "1", "2"));

        String str = new StringJoiner("", "[", "]").add("上海").toString();
        System.out.println(str);

        System.out.println(String.join("", "[", "上海", "]"));*/
        /*System.out.println(DateUtils.toDate("20210301", "yyyy-MM-dd"));
        String s = LocalDate.parse("20210301", DateTimeFormatter.ISO_DATE).plusDays(-1L).toString();*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String str = simpleDateFormat.parse("20210227").toInstant().atZone(ZoneId.systemDefault())
                .toLocalDate().plusDays(-1L).format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(str);
    }
}
