package com.qa.keyword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.exception.InvalidBrowserNameException;
import com.qa.utilites.Config;

public class Base {
	protected WebDriver driver;
	protected Keyword keyword;
	Config config = new Config();

	
	@BeforeMethod
	@Parameters("browserName")
	public void setUp() throws InvalidBrowserNameException {
		String browserName = config.getBrowserName();
		if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else {
			throw new InvalidBrowserNameException(browserName);
		}
		keyword = new Keyword(driver);
		keyword.launchUrl(config.getUrl());
		keyword.maximizeBrowser();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			keyword.closeBrowser();
			keyword.quitBrowser();
		}

	}
}
