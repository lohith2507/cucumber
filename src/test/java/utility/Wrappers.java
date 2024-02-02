package utility;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Wrappers {
    ExcelReader excelReader = new ExcelReader();
    static ScreenshotUtility screenshotutility = new ScreenshotUtility();

    public static String getdatafrom_excel(String sheet, String value) throws IOException {
       return  ExcelReader.getCellValue(sheet,value);
    }

    public static void writedatato_excel(String sheet, String colheader, String value) throws IOException {
        ExcelReader.writetoexcel(sheet,colheader,value);
    }

public static void takescreenshot(WebDriver driver)
{
    screenshotutility.takeScreenshot(driver);
}
    public Wrappers() throws IOException {

    }
}
