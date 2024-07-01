package com.qa.keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.exception.InvalidBrowserNameException;


public class Keyword {
	public static RemoteWebDriver driver;

	public void openBrowser(String browserName) throws InvalidBrowserNameException {
		if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else {
			throw new InvalidBrowserNameException(browserName);
		}

	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void clickOnElement(WebElement e) {
		e.click();
	}

	public void enterText(WebElement e, String text) {
		e.sendKeys(text);

	}

	public String getText(WebElement e) {
		return e.getText();
	}
	public void closeBrowser() {
		driver.close();
	}
	public void quitBrowser() {
		driver.quit();
	}

}
