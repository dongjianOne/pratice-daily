package com.dong.lambda;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author DongJian
 * @Date Created in 2020/6/30 10:19
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
@Slf4j
public class TestDist {


    public static void main(String[] args) {
        File file = new File("C:\\Users\\DJ\\Desktop\\估值接口");
        File[] files = file.listFiles();
        //获取文件名和文件最后一次修改日期
        System.out.println(files[2].getName() + "----" + new Date(files[2].lastModified()));
        System.out.println("=------------------------------------------------------------------=");
        String name = "dongjian.[MMDD]";
        // ”\\“相当于\
        System.out.println(name.replaceAll("\\[MMDD\\]", "20200707"));
        String str = "a_b_c";
        System.out.println("a_b_c---------" + str.substring(str.lastIndexOf("_") + 1));

        List<String> testList = null;
//        System.out.println(testList.stream().filter(a -> "1".equals(a)).collect(Collectors.toList()));
//        System.out.println("booleab----"+isMatching("SZHK_SJSDZ0610.DBF","szhk_sjsdz0610*"));

        log.info("---------------------------------字符分割-----------------------------------");
        String fileStr = "深圳最低备付金结息  \n";
//        String content = fileStr.replaceAll("\\s+$", ";");
        System.out.println("stringHandle--" + stringHandle(fileStr));

        log.info("-----------------------------buffer.split---------------------------------------");
        StringBuffer sb1 = new StringBuffer("a b c");
        System.out.println(sb1.insert(1, ";"));
        log.info("\n----------------------------------不区分大小写字符串比较---------------------------");
        String success = "SUCCESS";
        System.out.println("不区分大小写字符串比较:"+success.equalsIgnoreCase("SUCCESS"));
        log.info("\n----------------------------------longValue---------------------------");
        Long lo = 1L;
        System.out.println("long:"+lo);
        System.out.println("longValue:"+lo.longValue());


    }

    /**
     * @return java.util.List<java.lang.String>
     * @Description 字符串处理
     * @Author dongjian 2020/7/14 13:49
     * @Param [fileStr 入参字符串]
     **/
    private static List<String> stringHandle(String fileStr) {
        List<String> list = Arrays.asList(fileStr.split("\r|\n|\\s"));
        System.out.println("list--" + list);
        int count = 0;
        List<Integer> integerList = Lists.newArrayList();
        for (String l : list) {
            // 判断字符以数字结尾
            if (Pattern.compile("\\d+$").matcher(l).find()) {
                // 记录集合下标
                integerList.add(count);
            }
            count++;
        }
        Matcher matcher = Pattern.compile("\r|\n|\\s").matcher(fileStr);
        System.out.println("matcher--" + matcher);
        int midIndex = 0;
        int insertId = 0;
        StringBuffer sb = new StringBuffer(fileStr);
        while (matcher.find()) {
//            System.out.println("matcher.start--"+matcher.start());
            if (integerList.contains(midIndex)) {
                // 其他元素后移
                sb.insert(matcher.start() + insertId, ";");
                insertId++;
            }
            midIndex++;
        }
//        System.out.println("fileStr--"+sb.toString());
//        System.out.println("sb--"+Arrays.asList(sb.toString().replaceAll("\r|\n|\\s+","").split(";")));
//        System.out.println("midIndex--"+midIndex);
        return Arrays.asList(sb.toString().replaceAll("\r|\n|\\s", "").split(";"));
    }

    public static boolean isMatching(String src, String des) {
        if (!des.contains(".") && src.contains(".")) {
            src = src.replaceAll("\\.", "");
        }
        String des1 = des.replace("*", "\\w*");
        des1 = des1.replace("?", "\\w{1}");
        Pattern p = Pattern.compile(des1, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(src);
        return m.matches();
    }
}
