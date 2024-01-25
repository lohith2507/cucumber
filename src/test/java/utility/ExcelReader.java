package utility;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import stepDeff.Hooks;
import java.io.FileInputStream;
import java.io.IOException;
public class ExcelReader {
static Hooks hooks = new Hooks();
static String filePath= System.getProperty("user.dir")+"/src/main/resources/dataprovider/data.xlsx";
static String scenname = hooks.getcurrentscenrioname();
    public static String getCellValue( String sheetName, String colHeader) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            int rowIndex = -1;
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                Cell headerCell = row.getCell(0);
                if (headerCell.toString().equals(scenname)) {
                    rowIndex = i;
                    break;
                }
            }

            if (rowIndex == -1) {
                throw new RuntimeException("Row header not found: " + scenname);
            }
            int colIndex = -1;
            Row headerRow = sheet.getRow(0);
            for (int j = 1; j < colCount; j++) {
                Cell headerCell = headerRow.getCell(j);
                if (headerCell.toString().equals(colHeader)) {
                    colIndex = j;
                    break;
                }
            }
            if (colIndex == -1) {
                throw new RuntimeException("Column header not found: " + colHeader);
            }
            Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
            if (cell == null) {
                throw new RuntimeException("Cell not found at coordinates (" + rowIndex + ", " + colIndex + ")");
            }

            return cell.toString();

        }

    }


