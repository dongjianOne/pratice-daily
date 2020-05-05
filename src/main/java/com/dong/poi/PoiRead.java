package com.dong.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author DongJian
 * @Date Created in 2020/5/6 0:26
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class PoiRead {
    static String PATH = "E:\\dongjianGitHub\\pratice-daily";

    @Test
    public void testRead03() throws IOException {
        // 1.获取流
        FileInputStream fps = new FileInputStream("E:\\dongjianGitHub\\pratice-daily"+ File.separator+"任务完成情况统计表.xls");
        // 2.获取工作簿
        Workbook wb = new HSSFWorkbook(fps);
        // 3.获取工作表
        Sheet sheet = wb.getSheetAt(0);
        // 4.获取行
        Row row = sheet.getRow(0);
        // 5.获取列
        Cell cell = row.getCell(1);
        // 6.输出表格值
        System.out.println(cell.getStringCellValue());
    }
    @Test
    public void testRead07() throws IOException {
        // 1.获取流
        FileInputStream fps = new FileInputStream("E:\\dongjianGitHub\\pratice-daily"+ File.separator+"test07WriteBigData.xlsx");
        // 2.获取工作簿
        Workbook wb = new XSSFWorkbook(fps);
        // 3.获取工作表
        Sheet sheet = wb.getSheetAt(0);
        // 4.获取行
        Row row = sheet.getRow(0);
        // 5.获取列
        Cell cell = row.getCell(1);
        // 6.输出表格值 StringCellValue--输出字符串类型的值
//        System.out.println(cell.getStringCellValue());
        System.out.println(cell.getNumericCellValue());
    }
}
