package com.cybertek.step_definitions;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class DiceJobSearchStepDefs {

    @Given("User is on dice homepage")
    public void user_is_on_dice_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("dice.url"));
    }
    @When("User enters keyword and zipcode")
    public void user_enters_keyword_and_zipcode() {
       WebElement keyword = Driver.getDriver().findElement(By.id("typeaheadInput"));
        WebElement zipcode = Driver.getDriver().findElement(By.id("google-location-search"));

        keyword.sendKeys("java");
        zipcode.sendKeys("22102" + Keys.ENTER);

    }
    @Then("User should see search results")
    public void user_should_see_search_results() {
        WebElement jobCount = Driver.getDriver().findElement(By.id("totalJobCount"));
        System.out.println("Job Count = " + jobCount.getText());
        Driver.closeDriver();
    }
}
