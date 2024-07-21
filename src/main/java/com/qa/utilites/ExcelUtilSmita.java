package com.qa.utilites;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtilSmita {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	@DataProvider(name="LoginData")
	public  Object[][] getLoginData() throws IOException {
		String filepath=System.getProperty("user.dir")+"/src/main/resources/LoginData.xlsx";
		String sheetName="Sheet1";
		//return ExcelUtilSmita.readExcelSheet(filepath, sheetName);
		return ExcelUtilSmita.getExcelData(filepath, sheetName);
	}

	public static String[][] getExcelData(String filepath,String sheetName) throws IOException {
		FileInputStream fis= new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int rows= sheet.getLastRowNum();
		int cols= sheet.getRow(1).getLastCellNum();
		String[][] loginData=new String[rows][cols];
		for (int r = 1; r <=rows; r++) {
			XSSFRow row=sheet.getRow(r);
			for (int c = 0; c <cols; c++) {
				XSSFCell cell=row.getCell(c);
				loginData[r-1][c]=cell+"";
				}
		}
		workbook.close();
		return loginData;

	}
	
	public static Object[][]  readExcelSheet(String filepath, String sheetName) throws IOException {

		fis = new FileInputStream(filepath);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount ][cellCount];
		Iterator<Row> rowitr = sheet.iterator();
		rowitr.next();
		int i = 0;
		while (rowitr.hasNext()) {
			Row row = rowitr.next();
			for (int j = 0; j < cellCount; j++) {
				Cell cell = row.getCell(j);
				data[i][j] = cell.toString();
			}
			i++;
		}

		return data;
	}

}
