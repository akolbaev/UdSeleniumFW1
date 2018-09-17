package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

  
  static XSSFWorkbook workbook;
  static XSSFSheet sheet;

  public ExcelUtils(String excelPath, String sheetName) {
    try {
      //   workbook = new XSSFWorkbook(projectPath + "/excel/data.xlsx");
      workbook = new XSSFWorkbook(excelPath);
      sheet = workbook.getSheet(sheetName);
    } catch (IOException e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public int  getColumnCount() {
	  int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
	  System.out.println("number of columns: "+colCount);
  return colCount;
  }
  
  public  int getRowCount() {
	  int rowCount=0;

    try {
      

      rowCount = sheet.getPhysicalNumberOfRows();
      System.out.println("Number of rows: " + rowCount);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCause());
      e.printStackTrace();
    }
    return rowCount;
  }

  public  String getCellDataString(int rowNum, int colNum) {
	  String cellData = null;
    try {

      cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
      //System.out.println("Cell data: " + cellData);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCause());
      e.printStackTrace();
    }
  return cellData;
  }

  public  void getCellDataNumber(int rowNum, int colNum) {

    try {

      double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
      System.out.println("Cell data numberic: " + cellData);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCause());
      e.printStackTrace();
    }
  }
}
