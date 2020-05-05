package com.dong.thread2;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @Author DongJian
 * @Date Created in 2020/3/28 23:27
 * Utils: Intellij Idea
 * @Description: 线程创建方式三 实现Callable接口
 * @Version:1.0
 */
public class ThreadOfCallable implements Callable<Boolean> {
    private String url;
    private String fileName;

    // 构造器
    public ThreadOfCallable(String url,String fileName){
        this.url = url;
        this.fileName = fileName;
    }
    @Override
    public Boolean call() throws Exception {
        // 下载图片
        WebDownloader wd = new WebDownloader();
        wd.downloader(url,fileName);
        System.out.println("图片下载完毕："+fileName);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadOfCallable t1 = new ThreadOfCallable("https://bkimg.cdn.bcebos.com/pic/9e3df8dcd100baa1a5fd20114d10b912c9fc2e42?x-bce-process=image/resize,m_lfit,w_268,limit_1/format,f_jpg","1.jpg");
        ThreadOfCallable t2 = new ThreadOfCallable("https://bkimg.cdn.bcebos.com/pic/bd3eb13533fa828b14f65d51f41f4134960a5aaf?x-bce-process=image/resize,m_lfit,w_268,limit_1/format,f_jpg","2.jpg");
        ThreadOfCallable t3 = new ThreadOfCallable("https://bkimg.cdn.bcebos.com/pic/500fd9f9d72a60599d995d4c2734349b023bbadf?x-bce-process=image/resize,m_lfit,w_268,limit_1/format,f_jpg","3.jpg");
        // 创建服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> res1 = ser.submit(t1);
        Future<Boolean> res2 = ser.submit(t2);
        Future<Boolean> res3 = ser.submit(t3);
        // 获取结果
        Boolean b1 = res1.get();
        Boolean b2 = res2.get();
        Boolean b3 = res3.get();
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        //关闭服务
        ser.shutdown();
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