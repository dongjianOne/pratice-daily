package com.dong.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


/**
 * sheet页数据对象
 */
@Data
public class SheetFirst {

    @ExcelProperty(index = 0)
    private String first;
}
