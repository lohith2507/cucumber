package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtility {
    private static int screenshotCounter = 1;
    static BrowserDriver browserdriver = new BrowserDriver();
    public  void takeScreenshot(WebDriver driver) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Copy the screenshot file to a unique name
        File destinationFile = new File(System.getProperty("user.dir")+"/target/Extent Reports/screenshot" + screenshotCounter + ".png");
        File destinationfile1 = new File("C:/Users/ramak/OneDrive/Desktop/screenshots/screenshot"+screenshotCounter+".png");
        screenshotCounter++;

        try {
            FileUtils.copyFile(screenshotFile, destinationFile);
            FileUtils.copyFile(screenshotFile, destinationfile1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
