package com.dong.utils;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * @Author DongJian
 * @Date Created in 2020/5/11 16:04
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
public class ReadPdfUtil {
    //解析PDF文件为文本
        public static String getTextFromPDF(String pdfFilePath) {
            String result = null;
            FileInputStream is = null;
            PDDocument document = null;
            try {
                is = new FileInputStream(pdfFilePath);
                PDFParser parser = new PDFParser(is);
                parser.parse();
                document = parser.getPDDocument();
                PDFTextStripper stripper = new PDFTextStripper();
                result = stripper.getText(document);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (document != null) {
                    try {
                        document.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return result;
        }
}
