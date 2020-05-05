package com.dong.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Author DongJian
 * @Date Created in 2020/3/26 21:50
 * Utils: Intellij Idea
 * @Description: 多线程下载图片
 * @Version:1.0
 */
public class TestThread2  implements Runnable {

    private String url;
    private String fileName;
    // 构造器
    public TestThread2(String url,String fileName){
        this.url = url;
        this.fileName = fileName;
    }

    /**
     *  run() 执行体
     */
    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.downloader(url,fileName);
        System.out.println("图片下载完毕："+fileName);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://bkimg.cdn.bcebos.com/pic/9e3df8dcd100baa1a5fd20114d10b912c9fc2e42?x-bce-process=image/resize,m_lfit,w_268,limit_1/format,f_jpg","1.jpg");
        TestThread2 t2 = new TestThread2("https://bkimg.cdn.bcebos.com/pic/bd3eb13533fa828b14f65d51f41f4134960a5aaf?x-bce-process=image/resize,m_lfit,w_268,limit_1/format,f_jpg","2.jpg");
        TestThread2 t3 = new TestThread2("https://bkimg.cdn.bcebos.com/pic/500fd9f9d72a60599d995d4c2734349b023bbadf?x-bce-process=image/resize,m_lfit,w_268,limit_1/format,f_jpg","3.jpg");
        // 开启线程
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();

    }

}

/**
 * 下载器
 */
class WebDownloader{
    public void downloader(String url, String fiilName){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(fiilName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常,downloader方法出现问题");
        }
    }
}