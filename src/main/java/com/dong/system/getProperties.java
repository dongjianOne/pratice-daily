package com.dong.system;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * @author DongJian
 * @date Created in 2020/11/5 17:01
 * Utils: Intellij Idea
 * @description:
 * @version:1.0
 */
public class getProperties {

    public static void main(String[] args) throws UnknownHostException {
        Map<String, String> map = System.getenv();
//        System.out.println(System.getProperty("user.name"));
        System.out.println(map.get("USERNAME"));//获取用户名
        System.out.println(map.get("COMPUTERNAME"));//获取计算机名
        System.out.println(map.get("USERDOMAIN"));//获取计算机域名
        InetAddress address = InetAddress.getLocalHost();
        String ip = address.getHostAddress();
        String hostName = address.getHostName();
        System.out.println("ip:"+ip+"\nhostName:"+ hostName);
    }
}
