package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SpartanAddSpartanPage {

    public SpartanAddSpartanPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "genderSelect")
    public WebElement genderSelect;

    @FindBy(id = "phone")
    public WebElement phone;

    @FindBy(id = "submit_btn")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertMessage;

    public void selectGender(String gender){
        new Select(genderSelect).selectByVisibleText(gender);
    }
}
