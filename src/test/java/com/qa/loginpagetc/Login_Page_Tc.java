package com.qa.loginpagetc;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.keyword.Base;
import com.qa.keyword.Keyword;
import com.qa.pageobjects.LoginPage;
import com.qa.utilites.Config;

public class Login_Page_Tc extends Base {
	Config conf = new Config();

	@Test
	public void vrerifyLogin() {
		String expected = "Logged In Successfully";
		LoginPage loginPage= new LoginPage();
		loginPage.enterUserName(conf.getuserName());
		loginPage.enterpassword(conf.getpassword());
		loginPage.clickSubmit();
		String actual = loginPage.getMsg();
		Assert.assertEquals(actual, expected);

	}

}
