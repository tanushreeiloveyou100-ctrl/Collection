
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DataDrivenTest {
	
	static WebDriver driver;
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	static FileInputStream fin;
	static File fileDataSheet;
	
	public static void setUp() {
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static void openApp(String url) {
		driver.get(url);
	}
	
	
	public static void testLoginWithMultipleDataSet() throws IOException {
		
		fileDataSheet = new File("C:\\Users\\GopalDas\\Desktop\\practice_IBM\\FrameWorkPractice.xlsx");
		fin = new FileInputStream(fileDataSheet);
		wb = new XSSFWorkbook(fin);
		sh = wb.getSheetAt(0); 
		DataFormatter formatter = new DataFormatter();
		
		for(int i=1;i<=sh.getLastRowNum();i++) {
			
			WebElement userName = driver.findElement(By.name("username"));
			WebElement passWord = driver.findElement(By.name("password"));
			
			String ithUserName = formatter.formatCellValue(sh.getRow(i).getCell(0));
	        String ithPassword = formatter.formatCellValue(sh.getRow(i).getCell(1));
	        
	        System.out.println(ithUserName);
	        System.out.println(ithPassword);
	        
			
			userName.sendKeys(ithUserName);
			passWord.sendKeys(ithPassword);
			
			//click login
			driver.findElement(By.id("submit")).click();
			
		}
		
	}
	
	public static void login() {
		System.out.println("Logged in");
	}
	
	public static void registration() {
		System.out.println("Registration completed");
		
	}
	
	public static void loginHybrid(String _username, String _password) {
		
		WebElement userName = driver.findElement(By.name("username"));
		WebElement passWord = driver.findElement(By.name("password"));
		
		userName.sendKeys(_username);
		passWord.sendKeys(_password);
		
		System.out.println(_username);
		System.out.println(_password);
		
		//click login
		driver.findElement(By.id("submit")).click();
		
	}
	
	
	public static void keywordTestFrameWork() throws IOException {
		
		fileDataSheet = new File("C:\\Users\\GopalDas\\Desktop\\practice_IBM\\FrameWorkPractice.xlsx");
		fin = new FileInputStream(fileDataSheet);
		wb = new XSSFWorkbook(fin);
		sh = wb.getSheetAt(1); 
		DataFormatter formatter = new DataFormatter();

		
		for(int i=sh.getFirstRowNum();i<=sh.getLastRowNum();i++) {
			
			String keyword = formatter.formatCellValue(sh.getRow(i).getCell(1));
			
			if(keyword.equalsIgnoreCase("login")) {
				login();
			}
			
			if(keyword.equalsIgnoreCase("register")) {
				registration();
			}
			
		}
		
	}
	
	public static void hybridTestFramework() throws IOException {
		
		fileDataSheet = new File("C:\\Users\\GopalDas\\Desktop\\practice_IBM\\FrameWorkPractice2.xlsx");
		fin = new FileInputStream(fileDataSheet);
		wb = new XSSFWorkbook(fin);
		sh = wb.getSheetAt(2); 
		DataFormatter formatter = new DataFormatter();
		String username = "";
		String password = "";
		
		for(int i=sh.getFirstRowNum();i<=sh.getLastRowNum();i++) {
					
			String keyword = formatter.formatCellValue(sh.getRow(i).getCell(1));
			String testData = formatter.formatCellValue(sh.getRow(i).getCell(2));
			
			if(keyword.equalsIgnoreCase("Username")) {
				username = testData;
			}
			
			if(keyword.equalsIgnoreCase("Password")) {
				password = testData;
			}
			
		}
		
		loginHybrid(username,password);
		
		
	}
	
	
	public static void doSomeOperations() throws InterruptedException, IOException {
		
		//testLoginWithMultipleDataSet();
		
		//keywordTestFrameWork();
		hybridTestFramework();
		
	}
	
	public static void tearDown() throws InterruptedException {
		//System.out.println("completed");
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		setUp();
		String url = "file:///C:/Users/GopalDas/eclipse-workspace/Amit_1st_day/myWebApp/index.html";
		
		openApp(url);
		
		doSomeOperations();
		
		tearDown();
		
	}
	

}
