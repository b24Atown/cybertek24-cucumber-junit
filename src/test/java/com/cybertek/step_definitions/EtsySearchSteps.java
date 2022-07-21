package com.cybertek.step_definitions;

import com.cybertek.pages.EtsyAllCategoriesPage;
import com.cybertek.pages.EtsyHomePage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class EtsySearchSteps {

    WebDriver driver;

    @Given("User is on etsy homepage")
    public void user_is_on_etsy_homepage() {
        driver=Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("etsy.url"));
    }

    @Then("pagetitle should be as expected")
    public void pagetitle_should_be_as_expected() {
        Assert.assertEquals("Etsy Canada - Shop for handmade, vintage, custom, and unique gifts for everyone", driver.getTitle());

    }

    @When("user searches for wooden spoon")
    public void user_searches_for_wooden_spoon() {
        EtsyHomePage etsyHomePage = new EtsyHomePage();
        etsyHomePage.searchFor("wooden spoon");

    }

    @Then("page title should start with wooden spoon")
    public void page_title_should_start_with_wooden_spoon() {

        Assert.assertTrue("title did not match", driver.getTitle().startsWith("Wooden spoon"));

    }

    @When("user searches for empty value")
    public void userSearchesForEmptyValue() {
        EtsyHomePage etsyHomePage = new EtsyHomePage();
        etsyHomePage.searchField.clear();
        etsyHomePage.searchButton.click();
        //or etsyHomePage.searchFor("");
    }

    @Then("All categories should be displayed")
    public void allCategoriesShouldBeDisplayed() {
        Assert.assertEquals("Title is wrong","All categories | Etsy CA", driver.getTitle());
        EtsyAllCategoriesPage etsyAllCategoriesPage = new EtsyAllCategoriesPage();
        Assert.assertTrue(etsyAllCategoriesPage.allCategoriesHeader.isDisplayed());
    }
}
