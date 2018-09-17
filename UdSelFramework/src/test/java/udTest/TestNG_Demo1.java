package udTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo1 {
  WebDriver driver = null;
  
  
  @BeforeTest
  public void setUpTest() {
    String projectPath = System.getProperty("user.dir");
    System.out.println("This is your poject path: \n" + projectPath);

    System.setProperty(
        "webdriver.chrome.driver", projectPath + "/drivers/chromedrive/chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void googleSearchA() {

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
  }
}
