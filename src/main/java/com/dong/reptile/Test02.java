package com.dong.reptile;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * <p>
 * 实现
 * </p>
 *
 * @author: dong
 * @Date: 15:13 2021/3/26
 */
public class Test02 {

    // 爬虫入门
    public static void main(String[] args) throws IOException {
        //1. 打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //2. 输入网址； 发起get请求创建httpGet请求
        HttpGet httpGet = new HttpGet("http://www.efunds.com.cn/html/menu/38.htm");

        //3. 按回车，发起请求，返回响应； 使用HttpClient对象发起请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //4. 解析响应，获取数据
        // 判断状态码是否是200
        if(response.getStatusLine().getStatusCode()==200) {
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity,"UTF-8");
            System.out.println(content);
        }
        response.close();
        httpClient.close();
    }

}
