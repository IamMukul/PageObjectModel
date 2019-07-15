package com.gmail.testScripts;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.gmail.generic.BaseLibrary;

import com.gmail.pageClasses.LoginPage;

import junit.framework.Assert;

public class Test_LoginPage extends BaseLibrary {
	LoginPage loginPageObj;

	@BeforeMethod(groups = { "SmokeTesting", "NegativeTesting" })
	public void initializePageObjects() {
		loginPageObj = new LoginPage(driver);
	}

	@Test(groups = { "SmokeTesting", "NegativeTesting" })
	public void userEntersInvalidUserName() {

		// Opening Login Page for accessing Gmail
		driver.get("https://www.gmail.com");

		// Entering userName into the username field
		loginPageObj.fillUserName("hi@hmaj.com");

		// Clicking on next button for moving further
		loginPageObj.clickOnNextButton();

		// Check for error message
		String expectedErrorMessage = "Couldn't find your Google Account";
		String actualErrorMessage = loginPageObj.getEmailErrorMessage();
		Assert.assertEquals("Error in getting invalid email message", expectedErrorMessage, actualErrorMessage);
	}

	@Test(groups = { "SmokeTesting", "NegativeTesting" })
	public void userEntersValidUserNameButInvalidPassword() {

		// Opening Login Page for accessing Gmail
		driver.get("https://www.gmail.com");

		// Entering userName into the username field
		loginPageObj.fillUserName("cdf@hj.com");

		// Clicking on next button for moving further
		loginPageObj.clickOnNextButton();

		// Conducting check for visibility of password field
		boolean visiblityStatus = loginPageObj.isPasswordVisible();
		Assert.assertTrue(visiblityStatus);

		// User enters password
		loginPageObj.fillPassword("uugugugu");
		
		// Clicking on next button for moving further
		loginPageObj.clickOnNextButton();

		// Check for error message
		String expectedErrorMessage = "Wrong password. Try again or click Forgot password to reset it.";
		String actualErrorMessage = loginPageObj.getPasswordErrorMessage();
		Assert.assertEquals("Error in getting invalid password message", expectedErrorMessage, actualErrorMessage);
	}

	@Test(groups = { "NegativeTesting" })
	public void userEntersCorrectCredentials() {

		// Opening Login Page for accessing Gmail
		driver.get("https://www.gmail.com");

		// Entering userName into the username field
		loginPageObj.fillUserName("abc@gmail.com");

		// Clicking on next button for moving further
		loginPageObj.clickOnNextButton();

		// Conducting check for visibility of password field
		boolean visiblityStatus = loginPageObj.isPasswordVisible();
		Assert.assertTrue(visiblityStatus);

		// User enters password
		loginPageObj.fillPassword("uugugugu");

		// Clicking on next button for moving further
		loginPageObj.clickOnNextButton();
		
//		String actualTitle = loginPageObj.getTitle();
//    	System.out.println(actualTitle);
//    	Assert.assertTrue(actualTitle.contains("Inbox"));
	}
}
