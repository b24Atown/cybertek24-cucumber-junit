package com.cybertek.tests;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.VyTrackDashboardPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {

    BasePage basePage = new BasePage();
    VyTrackDashboardPage vyTrackDashboardPage = new VyTrackDashboardPage();

    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }

    @Test
    public void loginDDTTest() throws IOException {

        FileInputStream in = new FileInputStream("VyTrackQa2Users.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        for(int i = 1; i<= worksheet.getLastRowNum();i++) {
            String username = worksheet.getRow(i).getCell(0).toString();
            String password = worksheet.getRow(i).getCell(1).toString();
            String firstName = worksheet.getRow(i).getCell(2).toString();
            String lastName = worksheet.getRow(i).getCell(3).toString();


            basePage.login("user1", "UserUser123");

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(vyTrackDashboardPage.name));

            String actualFullName = vyTrackDashboardPage.name.getText();
            XSSFCell resultCell = worksheet.getRow(i).getCell(4);
            if(actualFullName.contains(firstName)&&actualFullName.contains(lastName)){
                resultCell.setCellValue("Pass");
            }else {
                resultCell.setCellValue("Fail");
            }

            vyTrackDashboardPage.name.click();
            wait.until(ExpectedConditions.elementToBeClickable(vyTrackDashboardPage.logoutBtn));
            vyTrackDashboardPage.logoutBtn.click();
        }
        FileOutputStream out = new FileOutputStream("VyTrackQa2Users.xlsx");
        workbook.write(out);

        in.close();
        out.close();
        workbook.close();

    }

    @After
    public void tearDown(){
        //Driver.getDriver().quit();
    }
}
