package tests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {
    @Test
    public void firstTest() throws IOException {


    }

    public ArrayList<String> getData(String testCaseName) throws IOException {
        ArrayList<String> a = new ArrayList<>();


        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//data//dataSheet.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int getNoOfSheets = workbook.getNumberOfSheets();
        //System.out.println(getNoOfSheets);

        for (int i = 0; i < getNoOfSheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("dataSet1")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                //Identify the testCase column by scanning the entire 1st row
                Iterator<Row> sheetRows = sheet.iterator();//sheet is Collection of rows
                Row firstRow = sheetRows.next();
                Iterator<Cell> cell = firstRow.cellIterator();//rows is collection of Cells.
                int k = 0;
                int column = 0;
                while (cell.hasNext()) {
                    Cell cellValue = cell.next();
                    if (cellValue.getStringCellValue().equalsIgnoreCase("TestCases")) {
                        column = k;

                    }
                    k++;
                }
                System.out.println(column);
                //once the column is identified, scan the entire test case column to find the 'purchase' testcase row
                while (sheetRows.hasNext()) {
                    Row row = sheetRows.next();
                    if (row.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
                        Iterator<Cell> cv = row.cellIterator();
                        while (cv.hasNext()) {
                            a.add(cv.next().getStringCellValue());
                        }
                    }

                }

            }

        }

        return a;
    }
}

