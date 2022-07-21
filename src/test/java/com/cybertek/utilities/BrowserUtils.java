package com.cybertek.utilities;

import org.openqa.selenium.JavascriptExecutor;

public class BrowserUtils {

    /*
   This method is used to pause the code for given seconds
   It's a static method so we can call:
   BrowserUtils.sleep(5);
    */
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollDown(int pixels){
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0,"+pixels+")");
    }

}
