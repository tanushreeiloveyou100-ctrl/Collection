package com.ibm.pageObjectModel.tests;

import com.ibm.pageObjectModel.pages.LoginPage;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
  protected WebDriver driver;
  
  protected String baseUrl = "https://practicetestautomation.com/practice-test-login/";
  
  protected String validUserName = "student";
  protected String validPassword = "Password123";
  
  @BeforeMethod
  public void setUp() {
	  WebDriver driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.get(baseUrl);
  }
  @AfterMethod
  public void tearDown() {
	  if(driver!=null) {
		  driver.quit();
	  }
  }
}
