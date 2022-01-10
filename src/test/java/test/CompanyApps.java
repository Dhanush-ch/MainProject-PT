package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import DriverSetup.SetDriver;

public class CompanyApps {

	
	public static WebDriver driver;
	Actions action;
	
	@BeforeSuite
	public void setDriver() throws Exception {
		SetDriver.getBrowser();
		driver = SetDriver.getWebDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		action  = new Actions(driver);
	}
	
	@Test
	public void displayApps() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='icomoon-windows8']")));
		driver.findElement(By.xpath("//span[@class='icomoon-windows8']")).click();
		driver.findElement(By.xpath("//button[@type = 'button' and contains(., 'Company Apps')]")).click();
		WebElement m = driver.findElement(By.xpath("//div[@class = 'mCSB_container']/child::div"));
		for(int i = 1; i < 147; i++) {
			
			if(i%6 == 0) {
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("arguments[0].scrollIntoView(true);", m);
				action.moveToElement(driver.findElement(By.xpath("//div[@class = 'mCSB_container']/child::div/child::div["+ i +"]/descendant::span[3]"))).sendKeys(Keys.PAGE_DOWN).build().perform();
				continue;
			}
			String appName = driver.findElement(By.xpath("//div[@class = 'mCSB_container']/child::div/child::div["+ i +"]/descendant::span[3]")).getText();
			
			System.out.println(appName);
		}
		
		driver.close();
		
	}
	
}
