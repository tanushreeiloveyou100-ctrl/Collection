package com.ibm.practice.testNg;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
  @Test
  public void testValidLogin(){
	  System.out.println("valid login");
	  System.out.println("Entering Username");
	  driver.findElement(By.id("user-name")).sendKeys("standard_user");
	  
	  System.out.println("Entering Password");
	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  
	  //click login
	  driver.findElement(By.id("login-button")).click();
	  
	  //check if it goes to product
	  String pageTitle = driver.findElement(By.className("title")).getText();
	  Assert.assertEquals("Products", pageTitle,"It's not loaded");
  }
  
  
}
