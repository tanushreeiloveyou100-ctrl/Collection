package com.ibm.testNgPractice2.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchWithFilters extends BaseTest {
  @Test
  public void todaysDeals() {
	  //click today's deals
	  driver.findElement(By.linkText("Today's Deals")).click();
	  
	  //see samsung phones
	  driver.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[2]/div[2]/div/span[1]/div/label/span/span")).click();

	  List<WebElement> allItems = driver.findElements(By.xpath("//a[@data-testid]"));
	  
	  System.out.println("Total items: " + allItems.size());
	  
	  for(WebElement item : allItems) {
		  System.out.println(item.getText());
	  }
	  
  }
}
