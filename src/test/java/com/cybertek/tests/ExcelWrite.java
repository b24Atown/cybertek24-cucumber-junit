package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    @Test
    public void writeToExcel() throws IOException {

        FileInputStream in = new FileInputStream("Employees.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet worksheet = workbook.getSheetAt(0);

        //add a column name "salary" and save into file

        XSSFCell salaryColCell = worksheet.getRow(0).createCell(3);
        salaryColCell.setCellValue("Salary");

        XSSFCell salary1 = worksheet.getRow(1).createCell(3);
        salary1.setCellValue("111000");

        XSSFCell salary2 = worksheet.getRow(2).createCell(3);
        salary2.setCellValue("114123");

        //save the changes

        FileOutputStream outputStream = new FileOutputStream("Employees.xlsx");
        workbook.write(outputStream);


    }
}
