package com.dong.threadlocal;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Author DongJian
 * @Date Created in 2020/9/1 13:20
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
@Slf4j
public class ThreadLocal01 {
    List<String> messages = Lists.newArrayList();
    public static final ThreadLocal<ThreadLocal01> holder = ThreadLocal.withInitial(ThreadLocal01::new);

    public static void main(String[] args) {
        ThreadLocal01.add("外面要下雨了我能送你回家嗎？");
        System.out.println(holder.get().messages);
        ThreadLocal01.clear();

    }

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();
        log.info("size:{}", holder.get().messages.size());
        return messages;
    }
}
