package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessChromeDemo {
	@Test
	public static void test() {
	    String projectPath = System.getProperty("user.dir");
	    System.setProperty(
	        "webdriver.chrome.driver", projectPath + "/drivers/chromedrive/chromedriver.exe");
	    
	    ChromeOptions options =new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1280,800");
		
	    WebDriver driver = new ChromeDriver(options);
					
		driver.get("https://google.com");
		WebElement  seachBox=driver.findElement(By.name("q"));
		seachBox.sendKeys("Houston");
		seachBox.sendKeys(Keys.RETURN);
		System.out.println(driver.getTitle() ); 
	
		driver.close();
		
	}
	
}
