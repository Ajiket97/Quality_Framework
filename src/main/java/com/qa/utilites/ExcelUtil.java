package com.qa.utilites;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtil {

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws IOException {
		String excelFilePath = System.getProperty("user.dir") + "/src/main/resources/LoginData.xlsx";
		String sheetName = "Sheet1";
		return ExcelUtil.getTestData(excelFilePath, sheetName);
	}

	public static Object[][] getTestData(String excelFilePath, String sheetName) throws IOException {
		
		Object[][] data = null;

	FileInputStream fis = new FileInputStream(excelFilePath); 
			Workbook workbook = new XSSFWorkbook(fis) ;
			Sheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
 
			data = new Object[rowCount - 1][colCount];

			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();

			int i = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				for (int j = 0; j < colCount; j++) {
					Cell cell = row.getCell(j);
					data[i][j] = cell.toString();
				}
				i++;
			}


		
		return data;
	}
}
