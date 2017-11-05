package Initialize;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class ExcelReader {
    public static String[][] read(String path) throws IOException, InvalidFormatException {

        DataFormatter dataFormatter = new DataFormatter();
        Workbook workbook = WorkbookFactory.create(new File(path));
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();
        int colNum = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[rowNum][colNum];

        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < sheet.getRow(i).getLastCellNum();j++) {
                data[i-1][j]=dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
                System.out.println(dataFormatter.formatCellValue(sheet.getRow(i).getCell(j)));
            }
        }
        return data;
    }
}
