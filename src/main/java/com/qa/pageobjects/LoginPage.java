package com.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.keyword.Keyword;

import net.bytebuddy.asm.Advice.This;

public class LoginPage {

	@FindBy(xpath = "//input[@name=\"username\"]")
	public WebElement userName;

	@FindBy(xpath = "//input[@name=\"password\"]")
	public WebElement password;

	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement submit;
	//
	@FindBy(xpath = "//h1[text()='Logged In Successfully']")
	public WebElement msg;
	
	private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public void enterUserName(String text) {
		userName.sendKeys(text);
	}

	public void enterpassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickSubmit() {
		submit.click();
	}

	public String getMsg() {
		String act = msg.getText();
		return act;

	}
	
	
	

}
