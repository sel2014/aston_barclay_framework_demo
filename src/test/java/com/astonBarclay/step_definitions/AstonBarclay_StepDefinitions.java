package com.astonBarclay.step_definitions;

import com.astonBarclay.pages.AstonBarclayHomePage;
import com.astonBarclay.pages.AstonBarclayVehiclesPage;
import com.astonBarclay.utilities.BrowserUtils;
import com.astonBarclay.utilities.ConfigurationReader;
import com.astonBarclay.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* I am creating POM to centralise my locators for easy access and maintainability
   I create constructor for the home page, use PageFactory class and use static initElements method
   which takes two parameters; the current instance of the driver and 'this' which refers to instance
   of the class
 */

public class AstonBarclay_StepDefinitions {

    AstonBarclayHomePage astonBarclayHomePage = new AstonBarclayHomePage();
    AstonBarclayVehiclesPage astonBarclayVehiclesPage = new AstonBarclayVehiclesPage();


    @Given("I am on the Aston Barclay homepage")
    public void i_am_on_the_aston_barclay_homepage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("astonBarclayURL"));
        BrowserUtils.waitFor(1);
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());

    }


    @When("I enter {string} into the search bar")
    public void iEnterIntoTheSearchBar(String string) {
        astonBarclayHomePage.vehiclesButton.click();

        astonBarclayVehiclesPage.searchBox.click();
        BrowserUtils.waitFor(1);
        astonBarclayVehiclesPage.searchBox.sendKeys(string);

    }

    @And("I click on the search button")
    public void iClickOnTheSearchButton() {
        BrowserUtils.waitFor(1);
        astonBarclayVehiclesPage.searchButton.click();

        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());

    }

    @Then("I should be directed to a search results page")
    public void iShouldBeDirectedToASearchResultsPage() {

        String expected = "Vehicle Search | Vehicle Remarketing and Vehicle Auction | Aston Barclay";
        BrowserUtils.verifyTitle(expected);
    }

    @And("the page should display a list of available Tesla vehicles")
    public void thePageShouldDisplayAListOfAvailableTeslaVehicles() {


        // Find registration number elements
        List<WebElement> listOfTeslas = Driver.getDriver().findElements
                (By.xpath("//div[@class='col-12 m-0 p-0 pt-1']"));

        List<String> registrationNumbers = new ArrayList<>();

        // Extract registration numbers
        for (WebElement eachTesla : listOfTeslas) {

            String reg = eachTesla.getText();
            registrationNumbers.add(reg);
        }
        System.out.print(registrationNumbers+",");
    }

}

