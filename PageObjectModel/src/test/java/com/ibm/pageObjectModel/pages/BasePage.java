package com.ibm.pageObjectModel.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
      protected WebDriver driver;
      protected WebDriverWait wait;
      protected JavascriptExecutor js;
      
      private static final int TIMEOUT = 10;
      
      public BasePage(WebDriver driver) {
    	  if (driver == null) {
              throw new IllegalArgumentException("WebDriver cannot be null!");
          }
    	  this.driver = driver;
    	  this.js = (JavascriptExecutor) driver;
    	  this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    	  
    	  PageFactory.initElements(driver, this);
      }
      
      protected void scrollToElement(WebElement element) {
          js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
      }
      
      protected void clickElement(WebElement element) {
    	  wait.until(ExpectedConditions.elementToBeClickable(element));
    	  element.click();
      }
      
      protected void typeText(WebElement element, String text) {
    	  wait.until(ExpectedConditions.visibilityOf(element));
    	  element.clear();
    	  element.sendKeys(text);
      }
      
      protected String getElmentText(WebElement element) {
    	  wait.until(ExpectedConditions.visibilityOf(element));
    	  return element.getText();
      }
      
      
}

