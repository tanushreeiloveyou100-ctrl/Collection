package com.ibm.practice.testNg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    
    @BeforeMethod
    public void loginBeforeEachTest() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_item")));
        
    }
    
    @AfterMethod
    public void cleanupAfterEachTest() {
        clearCart();

        logout();
        
    }
    
    private void clearCart() {
        try {
            // Check if cart has items
            List<WebElement> cartBadge = driver.findElements(By.className("shopping_cart_badge"));
            
            if (cartBadge.size() > 0) {
                driver.findElement(By.className("shopping_cart_link")).click();
                
                // Find all remove buttons and click them
                List<WebElement> removeButtons = driver.findElements(By.xpath("//button[starts-with(@id, 'remove-')]"));
                
                for (WebElement removeButton : removeButtons) {
                    removeButton.click();
                }
                
                System.out.println("Cart cleared!");
                
                // Go back to products page
                driver.findElement(By.id("continue-shopping")).click();
            } else {
              //  System.out.println("Cart is already empty.");
            }
        } catch (Exception e) {
           // System.out.println("Error clearing cart: " + e.getMessage());
        }
    }
    
    // Helper method to logout
    private void logout() {
        try {
            driver.findElement(By.id("react-burger-menu-btn")).click();
            
            // Wait for menu to open
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
            
            driver.findElement(By.id("logout_sidebar_link")).click();
           // System.out.println("Logged out successfully!");
        } catch (Exception e) {
            //System.out.println("Error during logout: " + e.getMessage());
        }
    }
    
    @Test(priority = 1)
    public void testProductsPageTitle() {
        System.out.println("Testing Products Page Title");
        String pageTitle = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(pageTitle, "Products", "Products page title mismatch!");
        System.out.println("Page Title: " + pageTitle);
    }
    
    @Test(priority = 2)
    public void testProductsDisplayed() {
        System.out.println("Testing if products are displayed");
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        Assert.assertTrue(products.size() > 0, "No products found on the page!");
        System.out.println("Total Products Displayed: " + products.size());
    }
    
    @Test(priority = 3)
    public void testProductCount() {
        System.out.println("Verifying product count");
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        int expectedCount = 6;
        Assert.assertEquals(products.size(), expectedCount, "Product count mismatch!");
        System.out.println("Expected: " + expectedCount + ", Actual: " + products.size());
    }
    
    @Test(priority = 4)
    public void testAddToCart() {
        System.out.println("Testing Add to Cart functionality");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        
        // Verify cart badge shows 1
        String cartBadge = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(cartBadge, "1", "Cart count mismatch!");
        System.out.println("Item added to cart. Cart count: " + cartBadge);
    }
    
    @Test(priority = 5)
    public void testRemoveFromCart() {
        System.out.println("Testing Remove from Cart functionality");
        
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        
        List<WebElement> cartBadge = driver.findElements(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadge.size(), 0, "Item not removed from cart!");
        System.out.println("Item removed from cart successfully");
    }
    
    @Test(priority = 6)
    public void testAddMultipleItems() {
        System.out.println("Testing adding multiple items to cart");
        
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        
        String cartBadge = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(cartBadge, "3", "Cart count should be 3!");
        System.out.println("Total items in cart: " + cartBadge);
    }
}
