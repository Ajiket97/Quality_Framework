package com.qa.utilites;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


package com.qa.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.DataProvider;
import org.testng.annotation


public class ExcelUtil {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

	public static int getRowCount(String filePath, String sheetName) throws IOException {
		fis = new FileInputStream(filePath);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		book.close();
		fis.close();
		return rows;
	}

	public static int getCellCount(String filePath, String sheetName) throws IOException {
		fis = new FileInputStream(filePath);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cells = sheet.getRow(0).getLastCellNum();
		book.close();
		fis.close();
		return cells;
	}

	public static String readExcelFile(String filePath, String sheetName, int rowNum, int cellNum) throws IOException {
		fis = new FileInputStream(filePath);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = sheet.getRow(0).getCell(cellNum);
		String data;
		try {
			data = cell.toString();
		} catch (Exception e) {
			data = "";
		}
		book.close();
		fis.close();
		return data;

	}

	public static void writeExcelFile(String filePath, String sheetName, int rowNum, int cellNum, String data)
			throws IOException {
		fis = new FileInputStream(filePath);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.createCell(cellNum);
		cell.setCellValue(data);
		fos = new FileOutputStream(filePath);
		book.write(fos);
		book.close();
		fis.close();
		fos.close();

	}
}

	public static Object[][] readExcel(String Filepath, String SheetName) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(Filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook book = null;
		try {
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = book.getSheet(SheetName);
		int rows = sheet.getLastRowNum();
		int coloumns = sheet.getRow(rows).getLastCellNum();
		Object[][] excelData = new Object[rows][coloumns];
		for (int r = 1; r <= rows; r++) {
			XSSFRow row = sheet.getRow(r);
			for (int c = 0; c < coloumns; c++) {
				XSSFCell cell = row.getCell(c);
				excelData[r - 1][c] = cell + "";
				System.out.println(	excelData[r - 1][c]);
			}
		}
		return excelData;
	}

}
