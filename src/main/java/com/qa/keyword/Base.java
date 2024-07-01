package com.qa.keyword;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.exception.InvalidBrowserNameException;
import com.qa.utilites.Config;

public class Base {

	Keyword keyword = new Keyword();
	Config config = new Config();

	@BeforeMethod
	public void setUp() throws InvalidBrowserNameException {
		keyword.openBrowser(config.getBrowserName());
		keyword.launchUrl(config.getUrl());
	}
	
	@AfterMethod
	public void tearDown() {
		keyword.closeBrowser();
		keyword.quitBrowser();
	}

}
