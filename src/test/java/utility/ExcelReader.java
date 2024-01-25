package utility;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import stepDeff.Hooks;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
        public static void writetoexcel(String sheetName, String colHeader,String value) throws IOException {
            FileInputStream fis = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowcount = sheet.getPhysicalNumberOfRows();
            int celcount  = sheet.getRow(0).getPhysicalNumberOfCells();
            int rowindex = 0;
            System.out.println(rowcount);
            for(int i =1; i<rowcount;i++)
            {
                Row row = sheet.getRow(i);
                Cell headercell = row.getCell(0);
                System.out.println(headercell.toString());
                System.out.println(scenname);
                if(headercell.toString().equals(scenname))
                {
                    rowindex = i;
                    break;
                }
            }
            System.out.println(rowindex);
            int cellindex = 0;
            Row headerrow = sheet.getRow(0);
            for(int j=1;j<celcount;j++)
            {
                Cell headercell = headerrow.getCell(j);
                if(headercell.toString().equals(colHeader))
                {
                    cellindex = j;
                    break;
                }
            }
            System.out.println(cellindex);
            if(sheet.getRow(rowindex).getCell(cellindex) == null)
            {
                sheet.getRow(rowindex).createCell(cellindex);
            }
            sheet.getRow(rowindex).getCell(cellindex).setCellValue(value);

          try ( FileOutputStream fos = new FileOutputStream(filePath))
          {
              workbook.write(fos);
          }
          workbook.close();

        }

    }


