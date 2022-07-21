package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpartanConfirmationPage {

    public SpartanConfirmationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertMessage;

    @FindBy(id="name")
    public WebElement name;

    @FindBy(id="gender")
    public WebElement gender;

    @FindBy(id="phone")
    public WebElement phone;



}
