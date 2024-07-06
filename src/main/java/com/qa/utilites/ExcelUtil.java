package com.qa.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelUtil {
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
