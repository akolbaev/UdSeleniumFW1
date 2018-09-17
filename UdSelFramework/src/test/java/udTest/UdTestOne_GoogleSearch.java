package udTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UdTestOne_GoogleSearch {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
	  googleSearch();
  }

  public static void googleSearch() {
    String projectPath = System.getProperty("user.dir");
    System.out.println("This is your poject path: \n" + projectPath);

    System.setProperty(
        "webdriver.chrome.driver", projectPath + "/drivers/chromedrive/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://google.com");
    WebElement searchBox = driver.findElement(By.name("q"));
    
   searchBox.sendKeys("Automation Step by Step");
   searchBox.sendKeys(Keys.RETURN);
   
   driver.close();
   System.out.println("test completed successfully!");
  }
}
