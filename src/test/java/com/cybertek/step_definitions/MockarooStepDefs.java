package com.cybertek.step_definitions;

import com.cybertek.pages.MockarooPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MockarooStepDefs {

    MockarooPage mockarooPage = new MockarooPage();

    @Given("User is on mockaroo homepage")
    public void user_is_on_mockaroo_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("mockaroo.url"));
    }

    @Given("Number of rows is {int}")
    public void number_of_rows_is(int numOfRows) {
        mockarooPage.inputRows(numOfRows + "");
    }

    @Given("Format is excel")
    public void format_is_excel() {

        mockarooPage.selectFormat("Excel");

    }

    @When("User clicks on preview")
    public void user_clicks_on_preview() {

        mockarooPage.preview.click();

    }

    @Then("following columns should be displayed:")
    public void following_columns_should_be_displayed(List<String> expectedColumns) {

        List<String> actualColumns = new ArrayList<>();
        for(WebElement each: mockarooPage.tableHeaders){
            actualColumns.add(each.getText());
        }

        Assert.assertEquals(expectedColumns,actualColumns);

    }

    @Then("{int} rows of data should be displayed")
    public void rows_of_data_should_be_displayed(int expectedRowsCount) {

        Assert.assertEquals(expectedRowsCount,mockarooPage.tableRows.size());

    }


    @When("User clicks on download")
    public void userClicksOnDownload() {

        mockarooPage.downloadBtn.click();
        
    }

    @Then("following columns should be displayed in excel file:")
    public void followingColumnsShouldBeDisplayedInExcelFile(List<String> expectedColumns) throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.home")+ "/Downloads/MOCK_DATA.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet worksheet = workbook.getSheetAt(0);

        int excelHeadersCount = worksheet.getRow(0).getPhysicalNumberOfCells();

        List<String> actualColumns = new ArrayList<>();

        for (int i = 0; i<excelHeadersCount;i++){
            actualColumns.add(worksheet.getRow(0).getCell(i).toString());
        }

        Assert.assertEquals(expectedColumns,actualColumns);
    }

    @And("{int} rows of data should be displayed in excel file")
    public void rowsOfDataShouldBeDisplayedInExcelFile(int numberOfRows) {



    }
}
