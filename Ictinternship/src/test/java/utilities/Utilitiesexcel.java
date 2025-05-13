package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class Utilitiesexcel {

static FileInputStream fls;
static XSSFWorkbook wkb;
static XSSFSheet sht;

public static String Excelread(String filepath,int sheetIndex,int rowIndex,int cellIndex) throws IOException {
	
	String value=" ";
	fls=new FileInputStream("C:\\Projectworkspace\\Ictinternship\\src\\test\\resources\\TestExcel.xlsx");
	wkb=new XSSFWorkbook(fls);
	sht=wkb.getSheetAt(sheetIndex);
	XSSFRow row = sht.getRow(rowIndex);
	if (row == null) return "";
    org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellIndex);
    if (cell == null) return "";
	DataFormatter formatter = new DataFormatter();
    value = formatter.formatCellValue(cell);
    wkb.close();
    fls.close();

    return value; 
}
    public static int getRowCount(String filepath, int sheetIndex) throws IOException {
        fls = new FileInputStream(filepath);
        wkb = new XSSFWorkbook(fls);
        sht = wkb.getSheetAt(sheetIndex);
        int rowCount = 0;
        for (int i = 0; i < sht.getPhysicalNumberOfRows(); i++) {
            XSSFRow row = sht.getRow(i);
            if (row != null && row.getCell(0) != null && !row.getCell(0).toString().trim().isEmpty()) {
                rowCount++;
            }
        }
        wkb.close();
        fls.close();
        return rowCount;
    } 
    

}





