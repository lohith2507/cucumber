package stepDeff;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utility.BrowserDriver;

public class StepDefinitions {
    BrowserDriver browserDriver = new BrowserDriver();
    WebDriver driver = browserDriver.getDriver();
// Perform your test steps

    @Given("landing on facebook login page")
    public void landing_on_facebook_login_page() throws InterruptedException {
        driver.get("www.facebook.com");
        Thread.sleep(200000);
        driver.manage().window().maximize();
        Thread.sleep(200000);
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
}
