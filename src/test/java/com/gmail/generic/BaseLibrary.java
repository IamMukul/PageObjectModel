package com.gmail.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.gmail.pageClasses.LoginPage;

public class BaseLibrary {
	public WebDriver driver;
	LoginPage loginPageObj;
	@BeforeMethod(groups = { "SmokeTesting", "NegativeTesting" })
	@Parameters("browser")
	public void setUp(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/Chrome Driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\Firefox Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}

	
	@AfterMethod(groups = { "SmokeTesting", "NegativeTesting" })
	public void tearDown() {
		driver.close();
	}
}
