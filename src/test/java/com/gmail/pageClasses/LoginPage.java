package com.gmail.pageClasses;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebInitializeWebDriver.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.gmail.generic.InitializeWebDriver;
import com.gmail.generic.Waits;

public class LoginPage {
	
	//WebInitializeWebDriver.driver InitializeWebDriver.driver = InitializeWebInitializeWebDriver.driver.InitializeWebDriver.driver;
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"identifierId\"]")
	public WebElement emailField;
	
	@FindBy(xpath="//*[text()=\"Next\"]")
	public WebElement nextButton;
	
	@FindBy(name="password")
	public WebElement passwordField;
	
	@FindBy(xpath="//div[text()=\"Couldn't find your Google Account\"]")
	public WebElement invalidEmailMessage;
	
	@FindBy(xpath="//span[text()=\"Wrong password. Try again or click Forgot password to reset it.\"]")
	public WebElement invalidPasswordMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillUserName(String userName) {
		Waits.eWaitForElementToBeClickable(driver, 5, emailField);
		emailField.sendKeys(userName);
	}
	public void clickOnNextButton() {
		Waits.eWaitForElementToBeClickable(driver, 15, nextButton);
		nextButton.click();
	}
	public void fillPassword(String password) {
		Waits.eWaitForElementToBeClickable(driver, 5, passwordField);
		passwordField.sendKeys(password);
	}
	public String getTitle() {
		return driver.getTitle();
	}
	public String getEmailErrorMessage() {
		Waits.eWaitForVisibility(driver, 10, invalidEmailMessage);
		return invalidEmailMessage.getText();
	}
	public String getPasswordErrorMessage() {
		Waits.eWaitForVisibility(driver, 10, invalidPasswordMessage);
		return invalidPasswordMessage.getText();
	}
	public boolean isPasswordVisible() {
		passwordField = Waits.eWaitForVisibility(driver, 5, passwordField);
		if(passwordField!=null) {
			return true;
		}
		return false;
	}
}
