package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MockarooPage {

    public MockarooPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='number']")
    public WebElement numberOfRowsField;

    @FindBy(id = "mui-component-select-file_format")
    public WebElement formatDropdown;

    @FindBy(xpath = "//li[.='Excel']")
    public WebElement excelOption;

    @FindBy(xpath = "//span[.='Preview']")
    public WebElement preview;

    @FindBy(xpath = "//table//th")
    public List<WebElement>tableHeaders;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "//span[.='Download Data']")
    public WebElement downloadBtn;

    public void inputRows(String num){
        numberOfRowsField.sendKeys(Keys.DELETE);
        numberOfRowsField.sendKeys(num);
    }

    public void selectFormat(String type){

        formatDropdown.click();
        Driver.getDriver().findElement(By.xpath("//li[.='"+type+"']")).click();

    }

}
