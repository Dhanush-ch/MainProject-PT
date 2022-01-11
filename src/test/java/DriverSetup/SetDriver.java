package DriverSetup;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SetDriver {
	
	public static WebDriver driver;
	public static String browser;
	
	public static String getBrowser() throws Exception {

		File file = new File("src/test/resources/MainProject.xlsx");
		FileInputStream fs = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fs);
		Sheet sheet1 = workbook.getSheet("Sheet1");
		Row row1 = sheet1.getRow(1);
		Cell cell0 = row1.getCell(0);
		browser = cell0.getStringCellValue();
		return browser;
	}
	
	public static WebDriver getWebDriver() throws Exception {
		
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Not available!! Select Chrome or firefox");
		}
				
		driver.manage().window().maximize();
		driver.get("https://be.cognizant.com");
		

		return driver;
		
	}
	
	public static void main(String args[]) throws Exception {
		SetDriver d = new SetDriver();
		
	}
	
	
}

