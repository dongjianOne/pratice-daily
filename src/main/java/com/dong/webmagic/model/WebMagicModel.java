package com.dong.webmagic.model;

import lombok.Data;

/**
 * <p>
 * 实现
 * </p>
 *
 * @author: dong
 * @Date: 17:51 2021/3/26
 */
@Data
public class WebMagicModel {

    /**
     * 定位名称h5的正则表达式
     */
    private String patternTitle;
    /**
     * 定位连接h5的正则表达式
     */
    private String patternLink;
    /**
     * 页面地址
     */
    private String url;
    /**
     * 关键字 ,隔开
     */
    private String keyword;
}
