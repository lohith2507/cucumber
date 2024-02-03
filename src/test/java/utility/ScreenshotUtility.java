package utility;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static utility.WordDocument.wordreport;

public class ScreenshotUtility {
    private static int screenshotCounter = 1;
    static BrowserDriver browserdriver = new BrowserDriver();
    public  void takeScreenshot(WebDriver driver,String imagename) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date currentDate = new Date();
            String formattedDate = sdf.format(currentDate);
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Copy the screenshot file to a unique name
            String imgpath = System.getProperty("user.dir") + "/target/Extent Reports/screenshot" + imagename + ".png";
            File destinationFile = new File(imgpath);
            System.out.println(imgpath);
            File destinationfile1 = new File("C:/Users/ramak/OneDrive/Desktop/screenshots/screenshot" + screenshotCounter + ".png");
            screenshotCounter++;
            FileUtils.copyFile(screenshotFile, destinationFile);
            FileUtils.copyFile(screenshotFile, destinationfile1);
            initializereport(imgpath, imagename);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializereport(String imgpath, String imagename) {
        threadingImg.get().add(imgpath);
        System.out.println(imgpath);
        threadingDescription.get().add(imagename);

    }
    protected static final ThreadLocal<List<String>> threadingDescription = new ThreadLocal<List<String>>() {
        protected  List<String> initialValue() {
            return new ArrayList<String>();
        }
    };
    protected static final ThreadLocal<List<String>> threadingImg = new ThreadLocal<List<String>>() {
        protected  List<String> initialValue() {
            return new ArrayList<String>();
        }
    };


    public static void generateReport() throws IOException, InvalidFormatException {
        List<String> ImgList = threadingImg.get();
        System.out.println("123");
        List<String> headingList = threadingDescription.get();
        wordreport(ImgList,headingList);
    }

}
