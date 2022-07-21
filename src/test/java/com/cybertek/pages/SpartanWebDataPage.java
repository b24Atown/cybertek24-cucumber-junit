package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpartanWebDataPage {

    public SpartanWebDataPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "add_spartan_btn")
    public WebElement addSpartanBtn;


}
