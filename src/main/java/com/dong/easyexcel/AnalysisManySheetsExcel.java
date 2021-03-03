package com.dong.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.dong.easyexcel.listener.*;
import com.dong.easyexcel.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 解析文件多个sheet页数据
 */
@Slf4j
public class AnalysisManySheetsExcel {

    public static final ResourceLoader RESOURCE_LOADER = new DefaultResourceLoader(Object.class.getClassLoader());

    public static void main(String[] args) throws IOException {

        Resource resource = RESOURCE_LOADER.getResource(ResourceUtils.CLASSPATH_URL_PREFIX + "template/test.xlsx");
        InputStream inputStream = resource.getInputStream();
        ExcelReader excelReader = null;
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            excelReader = EasyExcel.read(inputStream).build();
            AtomicReference<ReadSheet> readSheet1 = new AtomicReference<>();
            AtomicReference<ReadSheet> readSheet2 = new AtomicReference<>();
            AtomicReference<ReadSheet> readSheet3 = new AtomicReference<>();
            AtomicReference<ReadSheet> readSheet4 = new AtomicReference<>();
            AtomicReference<ReadSheet> readSheet5 = new AtomicReference<>();
            AtomicReference<ReadSheet> readSheet6 = new AtomicReference<>();
            CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> readSheet1.set(EasyExcel.readSheet(0).head(SheetFirst.class).registerReadListener(new SheetFirstListener()).build()));
            CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> readSheet2.set(EasyExcel.readSheet(1).head(SheetSecound.class).registerReadListener(new SheetSecoundListener()).build()));
            CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> readSheet3.set(EasyExcel.readSheet(2).head(SheetThird.class).registerReadListener(new SheetThirdListener()).build()));
            CompletableFuture<Void> future4 = CompletableFuture.runAsync(() -> readSheet4.set(EasyExcel.readSheet(3).head(SheetFourth.class).registerReadListener(new SheetFourthListener()).build()));
            CompletableFuture<Void> future5 = CompletableFuture.runAsync(() -> readSheet5.set(EasyExcel.readSheet(4).head(SheetFifth.class).registerReadListener(new SheetFifthListener()).build()));
            CompletableFuture<Void> future6 = CompletableFuture.runAsync(() -> readSheet6.set(EasyExcel.readSheet(5).head(SheetSix.class).registerReadListener(new SheetSixListener()).build()));
          /*  ReadSheet readSheet1 =
                    EasyExcel.readSheet(0).head(SheetFirst.class).registerReadListener(new SheetFirstListener()).build();
            ReadSheet readSheet2 =
                    EasyExcel.readSheet(1).head(SheetSecound.class).registerReadListener(new SheetSecoundListener()).build();*/
            // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
            CompletableFuture.allOf(future1, future2, future3,future4,future5,future6).join();
            excelReader.read(readSheet1.get(), readSheet2.get(), readSheet3.get(), readSheet4.get(), readSheet5.get(), readSheet6.get());
            stopWatch.stop();
            log.info(stopWatch.prettyPrint());
        } finally {
            if (excelReader != null) {
                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
                excelReader.finish();
            }
            IOUtils.closeQuietly(inputStream);
        }
    }
}
