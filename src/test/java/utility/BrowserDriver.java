package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriver {
    public  WebDriver driver;

    public ChromeOptions options;

    public BrowserDriver(){
        this.driver = driver;
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();

    }
    public WebDriver getDriver() {
        return this.driver;
    }
    public void close(){
        this.driver.close();
    }
}
