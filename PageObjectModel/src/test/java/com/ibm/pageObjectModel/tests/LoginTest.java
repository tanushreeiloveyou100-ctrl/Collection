package com.ibm.pageObjectModel.tests;

import com.ibm.pageObjectModel.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	private LoginPage loginPage;
	
	@BeforeMethod
	public void initializePageObject() {
		if(driver==null) {
			System.out.println("driver is null here in loginTest");
		}
		loginPage = new LoginPage(driver);
	}
	
	@Test
	public void testValidLogin() {
		System.out.println("valid login test:");
		
		Assert.assertTrue(loginPage.isLoginPageVisible());
		
		//then log in
		loginPage.login(validUserName, validPassword);
		Assert.assertTrue(loginPage.isLoginSucessfull());
		
	}
  
}
