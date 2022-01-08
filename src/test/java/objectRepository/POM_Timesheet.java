package objectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POM_Timesheet {
	
	public static WebDriver driver;
	
	
	public POM_Timesheet(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By username = By.id("user-name");
	By searchbox = By.id("searchbox");
	By searchButton = By.id("search-button");
	By ESATimesheet = By.xpath("(//span[@bind-html-compile='title'])[4]");
	public By firstWeek = By.id("CTS_TS_LAND_PER_DESCR30$0");
	public By secondWeek = By.id("CTS_TS_LAND_PER_DESCR30$1");
	public By thirdWeek = By.id("CTS_TS_LAND_PER_DESCR30$2");
	
	
	
	
	public String userName() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.presenceOfElementLocated(username));
		String user = driver.findElement(username).getText();
		return user;
		
	}
	
	public void searchForTimesheet() {
		driver.findElement(searchbox).sendKeys("Timesheet");
		driver.findElement(searchButton).click();
	}
	
	public void clickESATimesheet() {
		
		driver.findElement(ESATimesheet).click();

	}

}
