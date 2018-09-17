package udTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class TestNG_Demo2 {
  WebDriver driver = null;
  public static String browserName = null;
  
  @BeforeTest
  public void setUpTest() {
	  String projectPath = System.getProperty("user.dir");
	  PropertiesFile.getProperties();
	  
	  if(browserName.equalsIgnoreCase("chrome")){
		  System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedrive/chromedriver.exe");
		  driver = new ChromeDriver();
	  }else if(browserName.equalsIgnoreCase("internetexplorer")) {
		  System.setProperty("webdriver.ie.driver"	, projectPath+"/drivers/iedriver/IEDriverServer.exe");
		  driver = new InternetExplorerDriver();
	  }
  }
  

  @Test
  public void googleSearchB() {

    driver.get("https://google.com");
    WebElement searchBox = driver.findElement(By.name("q"));

    searchBox.sendKeys("Automation Step by Step");
    searchBox.sendKeys(Keys.RETURN);
  }
  @Test
  public void googleSearchC() {

    driver.get("https://google.com");
    WebElement searchBox = driver.findElement(By.name("q"));

    searchBox.sendKeys("Automation Step by Step");
    searchBox.sendKeys(Keys.RETURN);
  }
  
  @AfterTest
  public void tearDownTest() throws InterruptedException {
	 Thread.sleep(3000);
    driver.close();
    System.out.println("test completed successfully!");
    PropertiesFile.setProperties();
  }
}
