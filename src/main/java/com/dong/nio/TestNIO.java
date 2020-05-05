package com.dong.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author DongJian
 * @Date Created in 2020/3/22 1:02
 * Utils: Intellij Idea
 * @Description: Java NIO
 * @Version:1.0
 */
public class TestNIO {
    public static void main(String[] args) throws IOException {
        // 设置输入源 和输出地址
        String inFile = "C:\\Users\\DJ\\Desktop\\pufasql.sql";
        String outFile = "C:\\Users\\DJ\\Desktop\\sql.txt";
        // 获取数据源和输出地址的输入输出流
        FileInputStream fip = new FileInputStream(inFile);
        FileOutputStream fop = new FileOutputStream(outFile);
        // 获取数据源和输出地址的通道
        FileChannel fipChannel = fip.getChannel();
        FileChannel fopChannel = fop.getChannel();
        // 创建缓存区对象
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true){
            //从通道读取数据到缓存区
            // 若已读取到通道的末尾则返回-1
            int i = fipChannel.read(byteBuffer);
            if (i == -1){
                break;
            }
            // 传出数据准备
            byteBuffer.flip();
            // 从buffer中读取数据 & 传输到通道中
            fopChannel.write(byteBuffer);
            // 重置缓冲区
            byteBuffer.clear();
        }

    }
}

