package Pages;

import org.apache.cassandra.streaming.StreamOut;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDeff.StepDefinitions;
import utility.BrowserDriver;
import utility.ExcelReader;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Actions {
    public WebDriver driver;

    public Actions(WebDriver driver) {
        this.driver = driver;

    }

    public void landing_on_facebook_login_page() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("9618986372");
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

    public void iSearchForProduct() throws InterruptedException {
        WebElement search = driver.findElement(By.className("Pke_EE"));
        search.sendKeys("i phone");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> models = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
        for (WebElement model : models) {
            if (model.getText().equalsIgnoreCase("Apple iPhone 12 (Blue, 64 GB)")) {
                model.click();
                Thread.sleep(2000);
            }
        }

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        driver.switchTo().window(iterator.next());
        driver.switchTo().window(iterator.next());
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")).click();
        Thread.sleep(2000);
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
        ExcelReader excelReader = new ExcelReader();
        String cellvalue = ExcelReader.getCellValue("data","Value1");
        String cellvalue2 = excelReader.getCellValue("data","Value2");
        String cellvalue3 = excelReader.getCellValue("data","Value3");
        System.out.println(cellvalue);
        System.out.println(cellvalue2);
        System.out.println(cellvalue3);
    }

    public void navigateToExcelSheetAndWriteValues() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        ExcelReader.writetoexcel("data","Value1","Rajesh");
        ExcelReader.writetoexcel("data","Value2","Lohith");
        ExcelReader.writetoexcel("data","Value3","Sruthi");

    }
}