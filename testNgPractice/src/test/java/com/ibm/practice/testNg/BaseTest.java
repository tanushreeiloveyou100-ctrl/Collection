package com.ibm.practice.testNg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	public WebDriver driver;
	public static final String BASE_URL = "https://www.saucedemo.com/";
	
	@BeforeClass
	public void setUp() {
		System.out.println("Opening browser...");
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get(BASE_URL);
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("Closing browser");
		if(driver!=null) {
			driver.quit();
		}
	}
}
