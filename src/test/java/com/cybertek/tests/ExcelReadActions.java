package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class ExcelReadActions {

    String filepath = "Employees.xlsx";

    @Test
    public void readExcelSheetData() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(filepath);
        //goto worksheet 1. can do it by index
        XSSFSheet worksheet = workbook.getSheetAt(0);

        //print column names
        System.out.println("Column Names: " + worksheet.getRow(0).getCell(0));
        System.out.println("-------");
        //loop and print all 3 column names
        for (int i = 0; i<3;i++){
            System.out.println(worksheet.getRow(0).getCell(i));
        }
        //find out number of rows in the worksheet
        int rowsCount = worksheet.getPhysicalNumberOfRows();
        System.out.println("rowsCount = " + rowsCount); // starts counting from 1. also wont count empty rows if theres empty rows inbetween.
        
        int usedRowsCount = worksheet.getLastRowNum();
        System.out.println("usedRowsCount = " + usedRowsCount);//starts counting from 0. It counts empty rows as well.

        //print all first names
        System.out.println("All first names:");
        for (int i = 0; i<=usedRowsCount;i++){
            System.out.println(worksheet.getRow(i).getCell(0));
        }

        //loop and find "Fahima" in firstname column.
        //print her first | lastname | job id then exit loop

        System.out.println("Fahima Info:");

        for (int i = 0; i<=usedRowsCount;i++){
            if(worksheet.getRow(i).getCell(0).toString().equals("Fahima")){
                System.out.println(worksheet.getRow(i).getCell(0));
                System.out.println(worksheet.getRow(i).getCell(0) + " | " + worksheet.getRow(i).getCell(1) + " | " + worksheet.getRow(i).getCell(2));
                break;
            }
        }

        //if(worksheet.getRow(0).getCell(0) !=null) how to check if a column isnt null

    }

}
