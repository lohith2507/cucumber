package stepDeff;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static utility.BrowserDriver.driver;

public class StepDefinitions {
    @Given("landing on facebook login page")
    public void landing_on_facebook_login_page(){
        driver.get("www.facebook.com");
    }

    @Then("i enter {string} and {string}")
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
