package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import DriverSetup.SetDriver;
import objectRepository.POM_Timesheet;

public class Timesheet {

	public static WebDriver driver;
	static POM_Timesheet ts;
	
	@BeforeSuite
	public void setDriver() throws Exception {
		SetDriver.getBrowser();
		driver = SetDriver.getWebDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		ts = new POM_Timesheet(driver);
	}
	
	@Test(priority = 1)
	public void checkUser() {

		System.out.println(ts.userName());
		
	}
	
	@Test(priority = 2)
	public void searchTimesheet() throws Exception {
	
		ts.searchForTimesheet();
	}
	
	@Test(priority = 3)
	public void timesheetWindow() throws Exception {
		
		ts.clickESATimesheet();
		
		
		String oldTab = driver.getWindowHandle();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		driver.switchTo().window(newTab.get(0));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(ts.firstWeek));
		
		try {
			
			String thisWeek = driver.findElement(ts.firstWeek).getText(); 
			String prevWeek = driver.findElement(ts.secondWeek).getText(); 
			String prevPrevWeek = driver.findElement(ts.thirdWeek).getText(); 
			
			System.out.println(thisWeek + "----" + prevWeek + "------" + prevPrevWeek);
			
			AssertJUnit.assertEquals(thisWeek, dateClass.getDate(-6));
			AssertJUnit.assertEquals(prevWeek, dateClass.getDate(-13));
			AssertJUnit.assertEquals(prevPrevWeek, dateClass.getDate(-20));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Not equal");
		}
			
	}
	
	@AfterSuite
	public void closeDriver() {
		
		driver.quit();
	}
	
	
}
