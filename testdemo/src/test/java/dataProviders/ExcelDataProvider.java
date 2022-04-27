package dataProviders;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	static DataFormatter formatter  = new DataFormatter();
	static XSSFSheet sh ;
	static XSSFCell cell;
	static XSSFRow row ;

	@DataProvider(name ="excel-data")
	public static Object[][] excelDP() throws IOException{
		Object[][] arrObj = getExcelData("C://Users//Komal//git//testtask//testdemo//src//test//java//testData//LoginTestData.xlsx","Sheet1");
		return arrObj;
	}


	public static Object[][] getExcelData(String fileName, String sheetName){

		String[][] data = null;   //change to object 

		try
		{
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			sh = wb.getSheet(sheetName);
			row = sh.getRow(0);
			int noOfRows = sh.getPhysicalNumberOfRows();
			int noOfCols = row.getLastCellNum();			
			data = new String[noOfRows-1][noOfCols];

			for(int i =1; i<noOfRows;i++){
				for(int j=0;j<noOfCols;j++){
					row = sh.getRow(i);
					cell= row.getCell(j);
					data[i-1][j] = formatter.formatCellValue(cell);
					//data[i-1][j] = cell.getStringCellValue();
				}
			}
		}
		catch (Exception e) {
			System.out.println("The exception is: " +e.getMessage());
		}
		return data;
	}




}






