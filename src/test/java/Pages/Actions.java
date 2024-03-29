package Pages;

import org.apache.cassandra.streaming.StreamOut;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDeff.StepDefinitions;
import utility.BrowserDriver;
import utility.ExcelReader;
import utility.ScreenshotUtility;
import utility.Wrappers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Actions {
    public WebDriver driver;

    public Actions(WebDriver driver) throws IOException {
        this.driver = driver;

    }
Wrappers wrappers = new Wrappers();
    public void landing_on_facebook_login_page() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
         //locators.userbame.sendKeys("9618986372");
        Thread.sleep(2000);
        driver.findElement(By.id("pass")).sendKeys("9618986372");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Log In']")).click();
        Thread.sleep(2000);
        // driver.quit();
    }

    public void landingOnAmazonWebsite() throws InterruptedException {
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    public void iSearchForProduct() throws InterruptedException, IOException, InvalidFormatException {
        WebElement search = driver.findElement(By.className("Pke_EE"));
        search.sendKeys("i phone");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> models = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
        for (WebElement model : models) {
            if (model.getText().equalsIgnoreCase("Apple iPhone 12 (Blue, 64 GB)")) {
                Wrappers.takescreenshot(driver,"screenshot1");
                model.click();
                Thread.sleep(2000);
                Wrappers.takescreenshot(driver,"screenshot2");
            }
        }

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        driver.switchTo().window(iterator.next());
        driver.switchTo().window(iterator.next());
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")).click();
        Thread.sleep(2000);
        ScreenshotUtility.generateReport();
    }

    public void iSearchForProductByCategory() throws InterruptedException {
        List<WebElement> categories = driver.findElements(By.xpath("//span[@class='_1XjE3T']"));
        for (WebElement category : categories) {
            if (category.getText().equalsIgnoreCase("Electronics")) {
                category.click();
                Thread.sleep(1000);
                List<WebElement> types = driver.findElements(By.xpath("//a[@class='_1BJVlg']"));
                int c = 0;
                for (WebElement type : types) {
                    if (type.getText().equalsIgnoreCase("Audio")) {
                        c = 1;
                        type.click();
                        Thread.sleep(1000);
                        break;
                    }

                }
                if (c == 0) {
                    List<WebElement> types1 = driver.findElements(By.xpath("//a[@class='_1BJVlg _11MZbx']"));
                    for (WebElement type1 : types1) {
                        if (type1.getText().equalsIgnoreCase("Audio")) {
                            type1.click();
                            Thread.sleep(1000);
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    public void landingOnInstagramPage() throws InterruptedException {
        driver.get("https://www.instagram.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys("mehandhi._.creations");
        driver.findElement(By.name("password")).sendKeys("9618986372");
        driver.findElement(By.xpath("//*[text()='Log in']")).click();
        Thread.sleep(20000);
    }

    public void navigateToExcelSheetAndReadValues() throws IOException {

        String cellvalue = Wrappers.getdatafrom_excel("data","Value1");
        String cellvalue2 = Wrappers.getdatafrom_excel("data","Value2");
       String cellvalue3  = Wrappers.getdatafrom_excel("data","Value3");
        System.out.println(cellvalue);
        System.out.println(cellvalue2);
       System.out.println(cellvalue3);
    }

    public void navigateToExcelSheetAndWriteValues() throws IOException {
        Wrappers.writedatato_excel("data","Value1","Lohith");
        Wrappers.writedatato_excel("data","Value2","Rajesh");
        Wrappers.writedatato_excel("data","Value3","Sruthi");
    }
}