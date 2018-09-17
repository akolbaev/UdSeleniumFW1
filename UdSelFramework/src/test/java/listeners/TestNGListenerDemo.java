package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

// after creating testNG1 xml file... @Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {
	
	@Test
	public void test1() {
		System.out.println("I am inside test 1" ); 
	}
	@Test
	public void test2() {
		System.out.println("I am inside test 2" ); 
		String projectPath = System.getProperty("user.dir");
	    System.out.println("This is your poject path: \n" + projectPath);

	    System.setProperty(
	        "webdriver.chrome.driver", 
	        projectPath + "/drivers/chromedrive/chromedriver.exe");

	    		WebDriver driver = new ChromeDriver();
	    		 driver.get("http://google.com/");
	    		    //driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("automation");
	    		    //driver.findElement(By.className("q")).sendKeys("automation");
	    		    WebElement searchBox = driver.findElement(By.xpath("//input[@title='Sesarch']"));
	    		    searchBox.sendKeys("automation step by step");
	    		    searchBox.submit();
	    		    driver.close();
	}
	@Test
	public void test3() {
		System.out.println("I am inside test 3"); 
		throw new SkipException(null);
	}
	
	
	
}
