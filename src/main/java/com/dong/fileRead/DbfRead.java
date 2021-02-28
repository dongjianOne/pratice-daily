package com.dong.fileRead;

import cn.hutool.core.io.file.FileReader;

import java.util.LinkedList;

/**
 * dbf文件数据读取
 */
public class DbfRead {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Administrator\\Desktop\\日初期货保证金\\20210112\\0018_SG01_20210112_1_Capital.dbf";
//        FileReader fileReader = new FileReader("test.properties");
        FileReader fileReader = new FileReader(filePath);
        String s = fileReader.readString();
        System.out.println(s);
    }
}
