package utils;

public class ExcelUtilsDemo {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
	  String projectPath = System.getProperty("user.dir");
	     
	  ExcelUtils excel  = new ExcelUtils(projectPath+"/excel/data.xlsx", "Sheet1");
	  excel.getRowCount();
//	  excel.getCellDataNumber(1,  1);
//	  excel.getCellDataString(0, 0);
//	  excel.getColumnCount();
	  
	  System.out.println("####################");
	  
	  ExcelDataProvider provider = new ExcelDataProvider();
	  provider.testData(projectPath+"/excel/data.xlsx", "Sheet1");
	  
	  
  }
}
