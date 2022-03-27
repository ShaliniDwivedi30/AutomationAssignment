package commonUtilities;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelSheetReaderUtility {

    public ExcelSheetReaderUtility(String filepath, String getSheet, int getRow,int getCell) throws IOException {
        File file =    new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook wb=new HSSFWorkbook(inputStream);
        HSSFSheet sheet=wb.getSheet(getSheet);
        //Create a row object to retrieve row at row number
        HSSFRow row2=sheet.getRow(getRow);
        //Create a cell object to retrieve cell at cell number
        HSSFCell cell=row2.getCell(getCell);
        //Get the address in a variable
        String address= cell.getStringCellValue();
        System.out.println("Address is :"+ address);
    }


}

