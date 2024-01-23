package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriver {
    public  WebDriver driver;

    public WebDriver getDriver() {
        if(driver == null) {
           System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();

        }
        return driver;
    }
    public void close(){
        driver.close();
    }
}
