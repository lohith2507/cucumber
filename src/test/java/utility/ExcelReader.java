package utility;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import stepDeff.Hooks;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

static Hooks hooks = new Hooks();
static String scenname = hooks.getcurrentscenrioname();
    public static String getCellValue(String filePath, String sheetName, String colHeader) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            // Find the row index based on the row header
            int rowIndex = -1;
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                Cell headerCell = row.getCell(0); // Assuming the header is in the first column
                if (headerCell.toString().equals(scenname)) {
                    rowIndex = i;
                    break;
                }
            }

            if (rowIndex == -1) {
                throw new RuntimeException("Row header not found: " + scenname);
            }

            // Find the column index based on the column header
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

            // Get the cell value at the specified row and column indices
            Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
            if (cell == null) {
                throw new RuntimeException("Cell not found at coordinates (" + rowIndex + ", " + colIndex + ")");
            }

            return cell.toString();

        }

    }


