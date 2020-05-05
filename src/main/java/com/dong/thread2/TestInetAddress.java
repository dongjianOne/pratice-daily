package com.dong.thread2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress的使用
 可以通过ip获取到，也可以通过主机名获取InetAddress对象
 InetAddress的常用方法：getLocalHost()
 getHostName()
 */
public class TestInetAddress {

    public static void main(String[] args) throws UnknownHostException {
        // ip地址是唯一的
//        InetAddress inet = InetAddress.getByName("172.22.20.161");

        System.out.println(InetAddress.getLocalHost());
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());

    }
}