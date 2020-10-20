package com.itheima.service.impl;

import com.dong.model.AddTax;
import com.dong.utils.ReadExcelUtil;
import com.dong.utils.ReadPdfUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadPdfToExcel  {

        public static void main(String[] args) throws FileNotFoundException {
            String path="E:\\表文件\\192834697.pdf";
            readPdfToExcel1(path);
        }

        /*
         * 本文分为二个部分,
         * 一个是解析PDF表头文件到Excel模板中,
         * 一个方法是解析PDF表格内的数据到Excel模板数据中
         * */

        //生成Excel
        //增值税
        private static Sheet readPdfToExcel1(String path) throws FileNotFoundException {
            //模板文件所在路径
            String mbPath ="E:\\表文件\\192834697.xlsx";
            //工具类读取excel文件模板
            ReadExcelUtil readExcelUtil = new ReadExcelUtil(mbPath, "sheet");
            //表名
            String filename = null;

            //表头数据转移到excel
//            List<String> list = readPdfTitle1(path);
//            for (int i = 0; i < list.size(); i++) {
//                filename = list.get(i).trim();
//                readExcelUtil.replaceCellValue(readExcelUtil.getSheet().getRow(0).getCell(0), list.get(0));//表名
//                readExcelUtil.replaceCellValue(readExcelUtil.getSheet().getRow(3).getCell(0), list.get(1));//纳税人识别号
//                readExcelUtil.replaceCellValue(readExcelUtil.getSheet().getRow(2).getCell(0), list.get(2));//税款所属期
////                readExcelUtil.replaceCellValue(readExcelUtil.getSheet().getRow(5).getCell(0), list.get(3));//纳税人名称
//            }

            //表中数据转移到excel
            List<AddTax> addTaxes = readAddTax(path);
            //进行给Excel赋值
            int row = 3;
            for (int j = 0; j < 22; j++) {
                int cell = 0;
                AddTax addTax = addTaxes.get(j);
                readExcelUtil.replaceCellValue(readExcelUtil.getSheet().getRow(row).getCell(12 + cell - 1), addTax.getHurdles());
//                cell++;
//
//                readExcelUtil.replaceCellValue(readExcelUtil.getSheet().getRow(row).getCell(4 + cell - 1), addTax.getHurdles());
//                cell++;
//
//                readExcelUtil.replaceCellValue(readExcelUtil.getSheet().getRow(row).getCell(4 + cell - 1), addTax.getNumberOfMonth1());
//                cell++;
//
//                readExcelUtil.replaceCellValue(readExcelUtil.getSheet().getRow(row).getCell(4 + cell - 1), addTax.getNumberOfYear1());
//                cell++;
//
//                readExcelUtil.replaceCellValue(readExcelUtil.getSheet().getRow(row).getCell(4 + cell - 1), addTax.getNumberOfMonth2());
//                cell++;
//
//                readExcelUtil.replaceCellValue(readExcelUtil.getSheet().getRow(row).getCell(4 + cell - 1), addTax.getNumberOfYear2());
                row++;
            }

            //excel文件生成的位置,这边有点小问题
            String path2 = "e:\\";
            //让生成的文件不重复
            String name = path2 + filename + UUID.randomUUID().toString().replace("-", "") + ".xls";
            //生成的文件
            readExcelUtil.exportExcel(new File(name));
            //工具类获取Sheet对象,进行返回.
            Sheet sheet = readExcelUtil.getSheet();
            System.out.println(sheet.getRow(0).getCell(0).toString());//测试Sheet对象有没有值
            return sheet;

        }

        //解析表内数据
        private static List<AddTax> readAddTax(String path) {
            //如果传的是File文件可以使用
//        String path1 = path.getAbsolutePath();
            String text = ReadPdfUtil.getTextFromPDF(path);
            List<AddTax> list = new ArrayList<AddTax>();

            Map<Integer, String> map = new LinkedHashMap<Integer, String>();

            String[] split = text.split("\\r\\n");

            for (int i = 0; i < split.length; i++) {
                map.put(i, split[i]);
            }
            AddTax addTax = null;

            Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                addTax = new AddTax();//这个为JavaBean,用于封装数据
                Map.Entry<Integer, String> next = iterator.next();
                if (next.getKey() > 4) {
                    String s = next.getValue().replaceAll(" ", "#");
                    if (s.contains("税款计算") || s.contains("税款缴纳") || s.contains("受理信息")) {
                        continue;
                    }
                    String[] split1 = s.split("#");
//                        for (int i = 0; i < split1.length; i++) {
//                            addTax.setProject(split1[0]);
                    if (split1[split1.length-1].contains("0")){
                        addTax.setHurdles(split1[split1.length-1]);
                        list.add(addTax);
                    }
//                            addTax.setNumberOfMonth1("2");
//                            addTax.setNumberOfYear1("3");
//                            addTax.setNumberOfMonth2("4");
//                            addTax.setNumberOfYear2("5");
//                        }
                }
            }
            return list;
        }

        //读取表头数据
        private static List<String> readPdfTitle1(String path) {
            List<String> listTitle = new ArrayList<String>();
            String text = ReadPdfUtil.getTextFromPDF(path);
            String[] lineTitle = text.split("\\n");
            //表头前几行数据
            for (int i = 0; i < lineTitle.length; i++) {
                if (i <= 2) {
                    if (lineTitle[i].contains("税款所属期")) {
                        String[] timeLimit = lineTitle[i].split("税款所属期");
                        listTitle.add(timeLimit[0]);
                        listTitle.add("税款所属期" + timeLimit[1]);
                    } else if (lineTitle[i].contains("金额单位")) {
                        String[] moneyLimit = lineTitle[i].split("金额单位");
                        listTitle.add(moneyLimit[0]);
                        //   listTitle.add("金额单位： 人民币元（列至角分)"); 用不到
                    } else {
                        listTitle.add(lineTitle[i].trim());
                    }
                }
            }
            return listTitle;
        }
}
