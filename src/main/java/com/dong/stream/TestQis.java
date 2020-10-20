package com.dong.stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;

/**
 * @Author DongJian
 * @Date Created in 2020/9/10 11:16
 * Utils: Intellij Idea
 * @Description: 字符串判断提取关键字
 * @Version:1.0
 */
@Slf4j
public class TestQis {

    public static void main(String[] args) {
        String data = "港股通风控资金一级清算_深圳付款";
        TestQis testQis = new TestQis();
        String needData = testQis.getMarketFromSummary(testQis.setMapData(), data, null, true);
        log.info("业务类型为：{}",needData);
    }
    public String getMarketFromSummary(Map<String, String> map, String data, String data2, boolean type) {
        String result = "";
        if (StringUtils.isBlank(data) && StringUtils.isBlank(data2)) {
            return result;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String[] strings = entry.getKey().split("&");
            boolean flag = true;
            for (String s : strings) {
                boolean flagTemp = true;
                if (type) {
                    if (StringUtils.isNotBlank(data)) {
                        if (!data.contains(s)) {
                            flagTemp = false;
                        }
                    } else {
                        if (!data2.contains(s)) {
                            flagTemp = false;
                        }
                    }
                } else {
                    if (StringUtils.isNotBlank(data) && !data.contains(s)) {
                        flagTemp = false;
                    }
                }
                flag = flag && flagTemp;
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                result = entry.getValue();
                break;
            }
        }
        return result;
    }

    /**
     * 将数据库里的对象转成map形式，key为需要模糊匹配的内容，value为返回结果
     *
     * @param mapData
     *
     * 上海港股通	qisMarket	上海港股通:沪港通:港股通上海	季度结息市场，key为类型，value为模糊内容	0be1d4e090e111e9bc42526af7764f64
    深圳港股通	qisMarket	深圳港股通:深港通:港股通深圳	季度结息市场，key为类型，value为模糊内容	0f4b5dd690e111e9bc42526af7764f64

     * @param cleParaKeyvalueVOS
     */
    public Map<String, String> setMapData() {
        List<ParaKeyValue> cleParaKeyvalueVOS = Lists.newArrayList();
        Map<String, String> mapData = Maps.newHashMap();
        ParaKeyValue paraKeyValue = new ParaKeyValue();
        paraKeyValue.setId("0be1d4e090e111e9bc42526af7764f64");
        paraKeyValue.setParaCode("qisMarket");
        paraKeyValue.setParaKey("深圳");
        paraKeyValue.setParaNote("季度结息市场，key为类型，value为模糊内容");
        paraKeyValue.setParaValue("上海港股通:沪港通:港股通上海:深圳");
        cleParaKeyvalueVOS.add(paraKeyValue);
        for (ParaKeyValue cleParaKeyvalueVO : cleParaKeyvalueVOS) {
            String[] values = cleParaKeyvalueVO.getParaValue().split(":");
            for (String s : values) {
                mapData.put(s, cleParaKeyvalueVO.getParaKey()); //key为需要模糊匹配的内容，value为返回结果
            }
        }
        List<Map.Entry<String, String>> list = new ArrayList<>(mapData.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return compare;
            }
        });
        mapData.clear();
        for (Map.Entry<String, String> entry : list) {
            mapData.put(entry.getKey(), entry.getValue());
        }
        return mapData;
    }
}
