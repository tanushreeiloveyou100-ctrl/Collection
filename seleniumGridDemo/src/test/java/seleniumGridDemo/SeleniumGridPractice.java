package seleniumGridDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.URL;
import java.time.Duration;

public class SeleniumGridPractice {
    public static void main(String[] args) throws Exception {
        ChromeOptions options = new ChromeOptions();
        
		WebDriver driver = new RemoteWebDriver(
            new URL("http://localhost:4444"), 
            options
        );
        
		driver.manage().window().maximize();
        driver.get("https://www.google.com");
        Thread.sleep(Duration.ofSeconds(5));
        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }
}

