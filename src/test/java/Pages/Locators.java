package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Locators {
    public WebDriver driver;
    public Locators(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(id="email")
    WebElement username;

    @FindBy(id="pass")
    WebElement password;

    @FindBy(xpath = "//*[text()='Log In']")
    WebElement login;



}
