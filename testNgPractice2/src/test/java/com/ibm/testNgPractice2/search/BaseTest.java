package com.ibm.testNgPractice2.search;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	WebDriver driver;
  
	@BeforeSuite
	public void openUrl() {
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String BASE_URL = "https://www.amazon.in/";
		
		driver.get(BASE_URL);
	}
	
	@AfterSuite
	public void closeBrowser() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
