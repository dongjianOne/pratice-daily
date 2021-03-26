package com.dong.webmagic;

import com.dong.webmagic.model.WebMagicModel;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/**
 * <p>
 * 实现
 * </p>
 *
 * @author: dong
 * @Date: 15:30 2021/3/25
 */
public class FirstWebMagic implements PageProcessor, AfterExtractor{


        private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
        static ConcurrentMap<String, WebMagicModel> objectObjectConcurrentMap = Maps.newConcurrentMap();
        @Override
        public void process(Page page) {
            // 查询配置 todo
            System.out.println(page.getUrl());
            WebMagicModel wm = objectObjectConcurrentMap.get(page.getUrl().toString());
            page.putField("title", page.getHtml().xpath(wm.getPatternTitle()).all());
            page.putField("links", page.getHtml().xpath(wm.getPatternLink()).all());
            /*if (page.getResultItems().get("name") == null) {
                page.setSkip(true);
            }*/
            // 部分三：从页面发现后续的url地址来抓取
//            page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());

        }

        @Override
        public Site getSite() {
            return site;
        }

        public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {
            WebMagicModel wm1 = new WebMagicModel();
            wm1.setUrl("https://www.casc.org.cn/zzfb/");
            wm1.setPatternTitle("/html/body/div[@id='conPage']/div[@class='w1522']/div[@class='conContent w1100']/div[@class='newsCon clearfix']/ul/li/a/text()");
            wm1.setPatternLink("/html/body/div[@id='conPage']/div[@class='w1522']/div[@class='conContent w1100']/div[@class='newsCon clearfix']/ul/li/a/@href");
            WebMagicModel wm2 = new WebMagicModel();
            wm2.setUrl("http://www.amac.org.cn/aboutassociation/gyxh_xhdt/xhdt_xhgg/");
            wm2.setPatternTitle("/html/body/div[@class='content']/div[@class='c-box']/ul/li/a/text()");
            wm2.setPatternLink("/html/body/div[@class='content']/div[@class='c-box']/ul/li/a/@href");
            objectObjectConcurrentMap.put(wm1.getUrl(),wm1);
            objectObjectConcurrentMap.put(wm2.getUrl(),wm2);
            List<String> urls = Lists.newArrayList();
            urls.add(wm1.getUrl());
            urls.add(wm2.getUrl());
            OOSpider.create(new FirstWebMagic())
//                    .addUrl("https://www.casc.org.cn/zzfb/", "http://www.amac.org.cn/aboutassociation/gyxh_xhdt/xhdt_xhgg/")
                    .startUrls(urls)
                    .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
                    //开启5个线程抓取
                    .thread(5)
                    //启动爬虫
                    .run();
        }

    @Override
    public void afterProcess(Page page) {
        List<String> titles = page.getResultItems().get("title");
        List<String> links = page.getResultItems().get("links");

    }
}
