package com.ujiuye.demo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XSSFW {

    @Test
    public void demo1() throws IOException {
       //模拟数据库中的数据
        List<User> list=new ArrayList<>();
        list.add(new User(1,"jack",22));
        list.add(new User(2,"tomve",15));
        list.add(new User(3,"xixi",34));
        list.add(new User(4,"lolo",55));


        //创建工作簿
        XSSFWorkbook workbook=new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = workbook.createSheet("用户数据");
        //创建第一行，写表头
        XSSFRow sheetRow = sheet.createRow(0);
        sheetRow.createCell(0).setCellValue("id");
        sheetRow.createCell(1).setCellValue("name");
        sheetRow.createCell(2).setCellValue("age");
        //遍历集合，把集合数据写到excel
        for (int i=0;i<list.size();i++) {
            //获取集合的对象
            User user = list.get(i);
            //一个对象对应一行   行的下标要从1开始
            XSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getName());
            row.createCell(2).setCellValue(user.getAge());
        }
        //创建一个excel文件
        File file=new File("/Users/ClinEvol/Desktop/729/excel/user.xlsx");
        //把内容写入到file中
        workbook.write(new FileOutputStream(file));
        System.out.println("写入完毕");
    }
}
