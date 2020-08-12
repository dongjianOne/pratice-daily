package com.dong.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author DongJian
 * @Date Created in 2020/5/5 21:08
 * Utils: Intellij Idea
 * @Description: 03版本Excel 基本操作练习 （07版类似,只是对象不同 XSSFWorkBook)
 * 03版本是数据先写入内存，然后再一起写进磁盘
 * @Version:1.0
 */
public class PoiWriter03 {
    static String PATH = "E:\\dongjianGitHub\\pratice-daily";

    @Test
    public void testWrite03() throws Exception {
        // 1.创建工作簿
        Workbook wb = new HSSFWorkbook();
        // 2.创建一个工作表
        Sheet sheet = wb.createSheet("任务完成情况统计表");
        // 3.创建行 0开始（1,1)
        Row row1 = sheet.createRow(0);
        // 4.单元格 0开始
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("头寸管理");
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue("80%");
        // Java IO 输出流
        FileOutputStream fs = new FileOutputStream(PATH + File.separator+ "任务完成情况统计表.xls");
        //写入数据
        wb.write(fs);
        //关闭流
        fs.close();
        System.out.println("任务完成情况统计表"+"创建成功！");
    }

    /**
     * 03版 HSSFWorkBook
     * @throws IOException
     */
    @Test
    public void test03WriteBigData() throws IOException {
        long start = System.currentTimeMillis();
        // 1.创建工作簿
        Workbook wb = new HSSFWorkbook();
        // 2.创建工作表
        Sheet sheet = wb.createSheet("test03WriteBigData");
        // 批量写入数据
        for (int rowNum = 0; rowNum < 65536 ; rowNum++) {
            // 创建行
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10 ; cellNum++) {
                //创建列表格
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }

        }
        System.out.println("---导入数据完毕---");
        //输出流
        FileOutputStream fs = new FileOutputStream(PATH+File.separator+"test03WriteBigData.xls");
        // 写入数据
        wb.write(fs);
        //关闭流
        fs.close();
        long end = System.currentTimeMillis();
        System.out.println("使用的时间为："+(double)(end-start)/1000);
    }

    /**
     * 07版 XSSFWorkBook  写入数据非常慢，耗时较长，
     * 非常占用内存，有时会内存溢出，比如100万行数据，但是可以写入更多的数据，没有行数的限制
     * @throws IOException
     */
    @Test
    public void test07WriteBigData() throws IOException {
        long start = System.currentTimeMillis();
        // 1.创建工作簿
        Workbook wb = new XSSFWorkbook();
        // 2.创建工作表
        Sheet sheet = wb.createSheet("test03WriteBigData");
        // 批量写入数据
        for (int rowNum = 0; rowNum < 65537; rowNum++) {
            // 创建行
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                //创建列表格
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }

        }
        System.out.println("---导入数据完毕---");
        //输出流
        FileOutputStream fs = new FileOutputStream(PATH + File.separator + "test07WriteBigData.xlsx");
        // 写入数据
        wb.write(fs);
        //关闭流
        fs.close();
        long end = System.currentTimeMillis();
        System.out.println("使用的时间为：" + (double) (end - start) / 1000);
    }
    /**
     * 大文件写入加强版 SXSSFWorkBook
     * 原理：写入的过程会产生临时文件，需要及时清理临时文件
     * 默认前100条记录会写入内存，如果超过了这个数目则去前面的数据记录会写入临时文件
     * 需要注意的是依然可能存在消耗大量内存的问题，这基于你正在使用的功能，比如合并单元格、注释等操作依然是在内存中
     * 因此如果广泛的使用这些依然存储在内存的操作，大量消耗内存的情况依然存在
     */
    @Test
    public void test07WriteBigDataSXSSF() throws IOException {
        long start = System.currentTimeMillis();
        // 1.创建工作簿
        Workbook wb = new SXSSFWorkbook();
        // 2.创建工作表
        Sheet sheet = wb.createSheet("test03WriteBigData");
        // 批量写入数据 10W条
        for (int rowNum = 0; rowNum < 100000; rowNum++) {
            // 创建行
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                //创建列表格
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }

        }
        System.out.println("---导入数据完毕---");
        //输出流
        FileOutputStream fs = new FileOutputStream(PATH + File.separator + "test07WriteBigDataSXSSF.xlsx");
        // 写入数据
        wb.write(fs);
        //关闭流
        fs.close();
        //清理临时文件 SXSSFWorkBook 的方法
        ((SXSSFWorkbook)wb).dispose();
        long end = System.currentTimeMillis();
        System.out.println("使用的时间为：" + (double) (end - start) / 1000);
    }

    public static void main(String[] args) {
        // 1.创建工作簿
        Workbook wb = new HSSFWorkbook();
        // 2.创建一个工作表
        Sheet sheet = wb.createSheet("任务完成情况统计表");
        //获取指定sheet页
        Sheet sheetAt = wb.getSheetAt(0);
        // 测试输出sheet名称
        System.out.println(sheetAt.getSheetName());
    }
}
