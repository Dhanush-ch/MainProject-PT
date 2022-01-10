package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

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
import utilities.ExtentListeners;
import utilities.Screenshot;

public class Timesheet {

	public static WebDriver driver;
	static POM_Timesheet ts;
	
	
	public static WebDriver getDriver() {
		return driver;
	}
	
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
		ExtentListeners.test.log(Status.INFO, ts.userName());
		
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
			
			String screenshotPath = Screenshot.captureScreenshot(driver);
			ExtentListeners.test.addScreenCaptureFromPath(screenshotPath);
			
			String thisWeek = driver.findElement(ts.firstWeek).getText(); 
			String prevWeek = driver.findElement(ts.secondWeek).getText(); 
			String prevPrevWeek = driver.findElement(ts.thirdWeek).getText(); 
			
			System.out.println(thisWeek + "\n" + prevWeek + "\n" + prevPrevWeek);
			ExtentListeners.test.log(Status.INFO, thisWeek + "(Actual) " + dateClass.getDate(-6) + "(Expected)");
			ExtentListeners.test.log(Status.INFO, prevWeek + "(Actual) " + dateClass.getDate(-13) + "(Expected)");
			ExtentListeners.test.log(Status.INFO, prevPrevWeek + "(Actual) " + dateClass.getDate(-20) + "(Expected)");
			
			AssertJUnit.assertEquals(thisWeek, dateClass.getDate(-6));
			AssertJUnit.assertEquals(prevWeek, dateClass.getDate(-13));
			AssertJUnit.assertEquals(prevPrevWeek, dateClass.getDate(-20));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Not Matched!!");
			ExtentListeners.test.log(Status.INFO, "Not Matched!!");
		}
			
	}
	
	@AfterSuite
	public void closeDriver() {
		
		driver.quit();
	}
	
	
}
