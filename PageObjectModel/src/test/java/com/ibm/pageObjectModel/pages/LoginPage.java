package com.ibm.pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "username")
	private WebElement usernameField;
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(id = "submit")
	private WebElement submitButton;
	
	@FindBy(id = "login")
	private WebElement loginText;
	
	@FindBy(xpath = "//*[@id=\"loop-container\"]/div/article/div[1]/h1")
	private WebElement sucessfulLoginText;
	
	public LoginPage enterUsername(String username) {
		scrollToElement(usernameField);
		typeText(usernameField,username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		scrollToElement(usernameField);
		typeText(passwordField,password);
		return this;
	}
	
	public void clickSubmitButton() {
		scrollToElement(usernameField);
		clickElement(submitButton);
	}
	
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickSubmitButton();
	}
	
	public boolean isLoginPageVisible() {
		return loginText.getText().equals("Test login");
	}
	
	public boolean isLoginSucessfull() {
		return sucessfulLoginText.getText().equals("Logged In Successfully");
	}
	
	
}
