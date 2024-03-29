package stepDeff;

import Pages.Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BrowserDriver;

import java.io.IOException;

public class StepDefinitions {
    public BrowserDriver browserDriver = new BrowserDriver();
    WebDriver driver = browserDriver.getDriver();
// Perform your test steps
Actions actions = new Actions(driver);

    public StepDefinitions() throws IOException {
    }

    @Given("landing on facebook login page")
    public void landing_on_facebook_login_page() throws InterruptedException {
        actions.landing_on_facebook_login_page();
    }


    @Given("landing on amazon website")
    public void landingOnAmazonWebsite() throws InterruptedException {
       actions.landingOnAmazonWebsite();
    }

    @Then("i search for product")
    public void iSearchForProduct() throws InterruptedException, IOException, InvalidFormatException {
        actions.iSearchForProduct();
    }

    @Then("i search for product by category")
    public void iSearchForProductByCategory() throws InterruptedException {
        actions.iSearchForProductByCategory();
    }

    @Given("landing on instagram page")
    public void landingOnInstagramPage() throws InterruptedException {
        actions.landingOnInstagramPage();
    }

    @Given("navigate to excel sheet and read values")
    public void navigateToExcelSheetAndReadValues() throws IOException {
        actions.navigateToExcelSheetAndReadValues();
    }

    @Given("navigate to excel sheet and write values")
    public void navigateToExcelSheetAndWriteValues() throws IOException {
        actions.navigateToExcelSheetAndWriteValues();
    }
}
