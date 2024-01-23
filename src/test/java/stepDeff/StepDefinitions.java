package stepDeff;

import Pages.Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BrowserDriver;

public class StepDefinitions {
    public BrowserDriver browserDriver = new BrowserDriver();
    WebDriver driver = browserDriver.getDriver();
// Perform your test steps
Actions actions = new Actions(driver);
    @Given("landing on facebook login page")
    public void landing_on_facebook_login_page() throws InterruptedException {
        actions.landing_on_facebook_login_page();
    }
    @When("i enter {string} and {string}")
    public void iEnterAnd(String arg0, String arg1) {

    }
    @And("i click on login button")
    public void iClickOnLoginButton() {

    }
    @Then("i navigate to profile")
    public void iNavigateToProfile() {

    }
    @And("validate profilename")
    public void validateProfilename() {
    }

    @Given("landing on amazon website")
    public void landingOnAmazonWebsite() throws InterruptedException {
       actions.landingOnAmazonWebsite();
    }
}
