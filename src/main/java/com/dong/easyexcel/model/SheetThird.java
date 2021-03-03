package com.dong.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


/**
 * sheet页数据对象
 */
@Data
public class SheetThird {
    @ExcelProperty(index = 0)
    private String first;
    @ExcelProperty(index = 1)
    private String two;
    @ExcelProperty(index = 2)
    private String three;
    @ExcelProperty(index = 3)
    private String four;
    @ExcelProperty(index = 4)
    private String five;
    @ExcelProperty(index = 5)
    private String six;
    @ExcelProperty(index = 6)
    private String seven;
    @ExcelProperty(index = 7)
    private String eight;
}
