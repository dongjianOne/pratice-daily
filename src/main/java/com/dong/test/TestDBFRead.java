//package com.dong.test;
//
//import com.linuxense.javadbf.DBFField;
//import com.linuxense.javadbf.DBFReader;
//import com.linuxense.javadbf.DBFWriter;
//import com.yss.kayela.result.FileArray;
//import com.yss.kayela.result.FileProp;
//import com.yss.kayela.util.Kayela;
//import lombok.Setter;
//import org.apache.ibatis.annotations.Mapper;
//import org.assertj.core.util.Lists;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.ObjectUtils;
//
//import javax.swing.text.html.Option;
//import java.io.*;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//
///**
// * <p>
// * 实现
// * </p>
// *
// * @author: dong
// * @Date: 17:03 2021/2/4
// */
//public class TestDBFRead {
//    static Map<String,String> keywordMap = new HashMap<>();
//    public static void main(String[] args) throws Exception {
//        // 模糊匹配关键字 todo
//        keywordMap.put("当日结算准备金余额", "期货保证金");
//        keywordMap.put("dong", "期货保证金");
//        // 配置的文件目录 todo
//        List<String> tableOfContents = Arrays.asList("中信期货", "国泰君安期货");
//
//        String localDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
//        // 文档库配置信息 todo
//        String ip = "10.10.3.107";
//        String address = "http://10.10.3.107:9000";
//        String fixedCatalog = "gzqh";
//
//        Kayela kayela = new Kayela();
//        List<String> filePathList = Lists.newArrayList();
//        tableOfContents.stream().forEach(t -> {
//            // todo
//            String path = String.join("/", fixedCatalog, t, "20210218");
////            String path = "gzqh/中信期货/20210218";
//            try {
//                FileArray fileNameArray = kayela.getFileName(ip, path, null, null);
//                if (!ObjectUtils.isEmpty(fileNameArray)) {
//                    List<FileProp> fileProps = fileNameArray.getData();
//                    Optional.ofNullable(fileProps).orElseGet(Collections::emptyList).stream()
//                            .filter(f1 -> f1.getFileName().endsWith(".dbf")).forEach(f -> {
//                        filePathList.add(String.join("", address, f.getPath()));
//                    });
//                }
//                System.out.println(fileNameArray);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        /**
//         * 读取文件内容
//         */
//        filePathList.stream().forEach(f -> {
//            try {
//                List<DbfContent> lists = readDBF(f);
//                // 查询维护产品数据找到对应的产品
//                // 保存数据
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//
//    }
//
//    /**
//     * 读取dbf
//     *
//     * @param path 文件服务器全路径
//     */
//    public static List<DbfContent> readDBF(String path) throws Exception {
//        URL url = new URL(path);
//        URLConnection urlConnection = url.openConnection();
//        List<DbfContent> dataList = Lists.newArrayList();
//        InputStream fis = null;
//        try {
//            // 读取文件的输入流
//            fis = urlConnection.getInputStream();
//            // 根据输入流初始化一个DBFReader实例，用来读取DBF文件信息
//            DBFReader reader = new DBFReader(fis);
//            // 解决乱码
//            reader.setCharactersetName("GBK");
//            // 调用DBFReader对实例方法得到path文件中字段的个数
//            int fieldsCount = reader.getFieldCount();
//            // 取出字段信息
//            for (int i = 0; i < fieldsCount; i++) {
//                DBFField field = reader.getField(i);
//                System.out.println(field.getName());
//            }
//            Object[] rowValues;
//            // 一条条取出path文件中记录
//            while ((rowValues = reader.nextRecord()) != null) {
//                // 判断是否与关键字匹配
//                boolean flag = judgmentData(rowValues[1].toString());
//                if (flag) {
//                    DbfContent dbfContent = new DbfContent();
//                    dbfContent.setAccountID(rowValues[0].toString().trim());
////                    dbfContent.setItemDesc(rowValues[1].toString().trim());
//                    dbfContent.setItemValue(rowValues[2].toString().trim());
//                    dataList.add(dbfContent);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fis.close();
//            } catch (Exception e) {
//            }
//        }
//        return dataList;
//    }
//    private static boolean judgmentData(String data) {
//        for (Map.Entry<String, String> entry : keywordMap.entrySet()) {
//            boolean flag = true;
//            String[] split = entry.getKey().split("&");
//            for (String s : split) {
//                if (!data.contains(s)) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                return true;
//            }
//        }
//        return false;
//    }
//    /**
//     * 写dbf
//     *
//     * @param path
//     */
//    public static void writeDBF(String path) {
//        OutputStream fos = null;
//        try {
//            // 定义DBF文件字段
//            DBFField[] fields = new DBFField[3];
//            // 分别定义各个字段信息，setFieldName和setName作用相同，
//            // 只是setFieldName已经不建议使用
//            fields[0] = new DBFField();
//            // fields[0].setFieldName("emp_code");
//            fields[0].setName("semp_Test1");
//            fields[0].setDataType(DBFField.FIELD_TYPE_C);
//            fields[0].setFieldLength(10);
//            fields[0].setDecimalCount(0);
//            fields[1] = new DBFField();
//            // fields[1].setFieldName("emp_name");
//            fields[1].setName("emp_Test2");
//            fields[1].setDataType(DBFField.FIELD_TYPE_C);
//            fields[1].setFieldLength(20);
//            fields[1].setDecimalCount(0);
//            fields[2] = new DBFField();
//            // fields[2].setFieldName("salary");
//            fields[2].setName("emp_Test3");
//            fields[2].setDataType(DBFField.FIELD_TYPE_N);
//            fields[2].setFieldLength(12);
//            fields[2].setDecimalCount(2);
//            // DBFWriter writer = new DBFWriter(new File(path));
//            // 定义DBFWriter实例用来写DBF文件
//            DBFWriter writer = new DBFWriter();
//            // 把字段信息写入DBFWriter实例，即定义表结构
//            writer.setFields(fields);
//            // 一条条的写入记录
//            Object[] rowData = new Object[3];
//            rowData[0] = "1000";
//            rowData[1] = "John";
//            rowData[2] = new Double(5000.00);
//            writer.addRecord(rowData);
//            rowData = new Object[3];
//            rowData[0] = "1001";
//            rowData[1] = "Lalit";
//            rowData[2] = new Double(3400.00);
//            writer.addRecord(rowData);
//            rowData = new Object[3];
//            rowData[0] = "1002";
//            rowData[1] = "Rohit";
//            rowData[2] = new Double(7350.00);
//            writer.addRecord(rowData);
//            // 定义输出流，并关联的一个文件
//            fos = new FileOutputStream(path);
//            // 写入数据
//            writer.write(fos);
//            // writer.write();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fos.close();
//            } catch (Exception e) {
//            }
//        }
//    }
//
//
//}
//
//@Setter
//class DbfContent {
//    private String accountID;
//    private String itemDesc;
//    private String itemValue;
//}
