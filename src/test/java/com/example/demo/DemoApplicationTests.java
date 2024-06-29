package com.example.demo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.qrcode.ByteArray;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

@SpringBootTest
class DemoApplicationTests {

    private static final String ROOT_PATH = "/Users/zengxuebin/IdeaProjects/demo/src/main/resources/";

    private static final String LOGO_PATH = "/Users/zengxuebin/IdeaProjects/demo/src/main/resources/images/test.png";

    @Test
    void contextLoads() {
    }

    @Test
    void testPdf() {
        Document document = new Document(PageSize.A4);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ROOT_PATH + "hello.pdf"));
            document.open();
            Image logo = Image.getInstance(LOGO_PATH);

            // 设置图片的宽度和高度，可以根据需要调整
            float logoWidth = 50f; // 设置宽度，例如50像素
            float logoHeight = logo.getHeight() * logoWidth / logo.getWidth(); // 保持原始宽高比

// 创建一个Paragraph对象，用于放置logo和文本
            Paragraph paragraphWithLogo = new Paragraph();
//            paragraphWithLogo.add(logo.setAbsolutePosition(0, 0)); // 将图片放在左上角
//            paragraphWithLogo.add(new Chunk(" ", document.getFont())); // 添加一个空格，以便与文本分开

// 设置对齐方式
            paragraphWithLogo.setAlignment(Element.ALIGN_CENTER);

// 添加到文档
            document.add(paragraphWithLogo);

            Paragraph paragraph1 = new Paragraph("dddddddddddddddddddd");
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph1);

            Paragraph paragraph2 = new Paragraph("ddddddddddddddd");
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph2);

            Paragraph paragraph3 = new Paragraph("dddddddddd");
            paragraph3.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph3);

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    @Test
    void test() {
        String test = "absdjabsd.dbasidb.jepg";
        System.out.println(test.substring(test.lastIndexOf(".")));
    }

}
