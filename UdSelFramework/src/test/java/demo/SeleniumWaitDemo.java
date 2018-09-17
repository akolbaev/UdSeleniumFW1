package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {
	
	public static void main(String[] args) throws InterruptedException {
    seleniumWaits();
  }
	
	
	public static void seleniumWaits() throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir");
		 System.setProperty(
			        "webdriver.chrome.driver", 
			        projectPath + "/drivers/chromedrive/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit wait for 10 seconds
		// default time of implicit wait is 250 miliseconds
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation Java");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcdef")));
		
		driver.findElement(By.name("abck")).click();
		
		
		Thread.sleep(2500);
		driver.close();
		driver.quit();
	}
	
}
