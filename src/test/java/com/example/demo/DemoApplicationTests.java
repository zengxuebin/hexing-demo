package com.example.demo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.qrcode.ByteArray;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootTest
class DemoApplicationTests {

    private static final String ROOT_PATH = "/Users/zengxuebin/IdeaProjects/demo/src/main/resources/";

    @Test
    void contextLoads() {
    }

    @Test
    void testPdf() {
        Document document = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(ROOT_PATH + "hello.pdf"));
            document.addTitle("example of PDF");
            document.open();
            document.add(new Paragraph("Hello World!"));
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    @Test
    void testExcel() {
        try {
            // 1. 获取工作簿
            XSSFWorkbook workbook = new XSSFWorkbook();
            // 2. 获取工作表
            XSSFSheet sheet = workbook.createSheet("工作表一");
            // 3.创建行
            XSSFRow row = sheet.createRow(0);
            // 4.创建单元格
            row.createCell(0).setCellValue("郭明然");
            row.createCell(1).setCellValue("窦凯欣");
            row.createCell(2).setCellValue("郭明然");
            // 创建行
            XSSFRow row1 = sheet.createRow(1);
            // 创建单元格
            row1.createCell(0).setCellValue("汤姆");
            row1.createCell(1).setCellValue("杰瑞");
            row1.createCell(2).setCellValue("皮神");

            FileOutputStream out = new FileOutputStream(ROOT_PATH + "test.xlsx");
            workbook.write(out);
            out.flush(); // 刷新资源
            // 释放资源
            out.close();
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
