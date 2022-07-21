package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LyftFairEstimatePage {

    public LyftFairEstimatePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "fare-start")
    public WebElement pickup;

    @FindBy(name = "fare-end")
    public WebElement dropOff;

    @FindBy(xpath = "//button[.='Get estimate']")
    public WebElement getEstimateBtn;

    @FindBy(xpath = "//h3[.='RIDE TYPES']")
    public WebElement rideTypesHeader;

    @FindBy(xpath = "//tr[1]/td[3]")
    public WebElement liftPrice;

    @FindBy(xpath = "//small[.='Please select a valid location.']")
    public WebElement errorMsg;

    public void enterPickupLocation(String location){
        pickup.sendKeys(location);
    }
}
