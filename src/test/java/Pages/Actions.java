package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDeff.StepDefinitions;
import utility.BrowserDriver;

public class Actions {
    public WebDriver driver;

    public Actions(WebDriver driver)
    {
        this.driver = driver;

    }

   public void landing_on_facebook_login_page() throws InterruptedException {
       driver.get("https://www.facebook.com/");
       Thread.sleep(2000);
       driver.manage().window().maximize();
       Thread.sleep(2000);
       driver.findElement(By.id("email")).sendKeys("9948631194");
       Thread.sleep(2000);
       driver.findElement(By.id("pass")).sendKeys("9948631194");
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[text()='Log In']")).click();
       Thread.sleep(2000);
      // driver.quit();
   }
   public void landingOnAmazonWebsite() throws InterruptedException {
       driver.get("https://www.amazon.com/");
       Thread.sleep(2000);
   }

}
