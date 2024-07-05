package com.qa.loginpagetc;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.keyword.Base;
import com.qa.pageobjects.LoginPage;
import com.qa.utilites.Config;
import com.qa.utilites.ExcelUtil;

public class LoginTDD extends Base {
	Config conf = new Config();

	@Test
	public static void loginTDD() throws IOException, InterruptedException {
		LoginPage loginPage = new LoginPage();
		String filePath = System.getProperty("user.dir") + "/src/main/resources/data.xlsx";
		int rows = ExcelUtil.getRowCount(filePath, "Sheet1");
		System.out.println(rows);
		String expected = "Logged In Successfully";
		for (int i = 1; i <= rows; i++) {
			String userName = ExcelUtil.readExcelFile(filePath, "Sheet1", i, 0);
			String password = ExcelUtil.readExcelFile(filePath, "Sheet1", i, 1);
			loginPage.enterUserName(userName);
			loginPage.enterpassword(password);
			loginPage.clickSubmit();
			Thread.sleep(5000);
			String actual = loginPage.getMsg();
			Assert.assertEquals(actual, expected);
		}

	}

}
