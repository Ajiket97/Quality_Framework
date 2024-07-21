package com.qa.keyword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Keyword {
	private WebDriver driver;

	public Keyword(WebDriver driver) {
		this.driver = driver;
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
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
