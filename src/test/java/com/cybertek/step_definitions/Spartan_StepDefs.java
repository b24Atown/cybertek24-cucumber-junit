package com.cybertek.step_definitions;

import com.cybertek.pages.SpartanAddSpartanPage;
import com.cybertek.pages.SpartanConfirmationPage;
import com.cybertek.pages.SpartanHomePage;
import com.cybertek.pages.SpartanWebDataPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.DB_Util;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class Spartan_StepDefs {

    Map<String,String> spartanMap = new HashMap<>();

    @Given("User is on spartan  homepage")
    public void user_is_on_spartan_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("spartan.url"));

    }
    @When("User goges to Web Data page")
    public void user_goges_to_web_data_page() {

        SpartanHomePage spartanHomePage = new SpartanHomePage();
        spartanHomePage.WebDataLink.click();

    }
    @When("User clicks on add spartan")
    public void user_clicks_on_add_spartan() {

        SpartanWebDataPage spartanWebDataPage = new SpartanWebDataPage();
        spartanWebDataPage.addSpartanBtn.click();

    }
    @When("eenters following data:")
    public void eenters_following_data(Map<String,String> dataTable) {
        spartanMap.putAll(dataTable);
        SpartanAddSpartanPage addSpartanPage = new SpartanAddSpartanPage();
        addSpartanPage.name.sendKeys(dataTable.get("name"));
        addSpartanPage.selectGender(dataTable.get("gender"));
        addSpartanPage.phone.sendKeys(dataTable.get("phone"));
        addSpartanPage.submitBtn.click();

    }
    @Then("success message should be displayed")
    public void success_message_should_be_displayed() {
        SpartanAddSpartanPage addSpartanPage = new SpartanAddSpartanPage();
        Assert.assertEquals("Successfully Added new Data!",addSpartanPage.alertMessage.getText());

    }
    @Then("data on confirmation page must be the same")
    public void data_on_confirmation_page_must_be_the_same() {
        SpartanConfirmationPage spartanConfirmationPage = new SpartanConfirmationPage();
        Assert.assertEquals(spartanMap.get("name"),spartanConfirmationPage.name.getAttribute("value"));
        Assert.assertEquals(spartanMap.get("gender"), spartanConfirmationPage.gender.getAttribute("value"));
        Assert.assertEquals(spartanMap.get("phone"),spartanConfirmationPage.phone.getAttribute("value"));

    }

    @And("data in database must match")
    public void dataInDatabaseMustMatch() {
        Map<String,Object> rowMap = DB_Util.getRowMap("Select * from spartans where name = 'ardit'");
        Assert.assertEquals(spartanMap.get("name"),rowMap.get("NAME"));
        Assert.assertEquals(spartanMap.get("gender"),rowMap.get("GENDER"));
        Assert.assertEquals(spartanMap.get("phone"),rowMap.get("PHONE"));

        //delete spartan data after verification so you dont add duplicate data
        DB_Util.executeQuery("Delete from spartans where name = 'ardit'");

    }
}
