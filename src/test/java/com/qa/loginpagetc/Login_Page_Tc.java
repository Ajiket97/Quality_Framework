package com.qa.loginpagetc;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.keyword.Base;
import com.qa.pageobjects.LoginPage;
import com.qa.utilites.Config;
import com.qa.utilites.ExcelUtilSmita;

public class Login_Page_Tc extends Base {
	Config conf = new Config();

	@Test(dataProvider = "LoginData", dataProviderClass = ExcelUtilSmita.class)
	/*
	 * SDET Pavan mmetrhod public void vrerifyLogin() { String expected =
	 * "Logged In Successfully"; LoginPage loginPage = new LoginPage();
	 * loginPage.enterUserName(conf.getuserName());
	 * loginPage.enterpassword(conf.getpassword()); loginPage.clickSubmit(); String
	 * actual = loginPage.getMsg(); Assert.assertEquals(actual, expected); }
	 */
	public void vrerifyLogin(String id, String pass) {
		String expected = "Logged In Successfully";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(id);
		loginPage.enterpassword(pass);
		loginPage.clickSubmit();
		String actual = loginPage.getMsg();
		Assert.assertEquals(actual, expected);

	}
}
