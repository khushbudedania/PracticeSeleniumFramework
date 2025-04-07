package org.example.Utils;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcelReader {

        // Apache POI
        // Read the File
        //  Workbook Create
        // Sheet
        // Row and Cell
        // 2D Object  - getData()

        static Workbook book;
        static Sheet sheet;

        public static String SHEET_PATH = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";

        public static Object[][] getTestDataFromExcel(String sheetName) throws IOException {


            FileInputStream file = null;
            try {
                file = new FileInputStream(SHEET_PATH);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }


            book = WorkbookFactory.create(file);
            sheet  = book.getSheet(sheetName);

            Object[][] data = new Object[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getLastCellNum()];

            // 5x2

            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++)
            {
                for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                    data[i][j] = sheet.getRow(i).getCell(j).toString();
                }
            }
            return data;
        }

    public static Object[][] getTestDataFromSQL(String sheetName){
        return null;
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        return getTestDataFromExcel("LoginData");
        }
}


