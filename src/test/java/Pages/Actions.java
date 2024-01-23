package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepDeff.StepDefinitions;
import utility.BrowserDriver;

public class Actions {
    public WebDriver driver;

    public Actions(WebDriver driver)
    {
        this.driver = driver;

    }
    Locators locators = new Locators(driver);
   public void landing_on_facebook_login_page() throws InterruptedException {

       driver.get("https://www.facebook.com/");
       Thread.sleep(200);
       driver.manage().window().maximize();
       Thread.sleep(200);
       locators.username.sendKeys("9948631194");
       Thread.sleep(200);
       locators.password.sendKeys("9948631194");
       Thread.sleep(200);
       locators.login.click();
       Thread.sleep(200);
       driver.quit();
   }

}
