package udTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;
public class GoogleSearchTest {

	private static WebDriver driver = null;
	
  public static void main(String[] args) {
    // TODO Auto-generated method stub
	  googleSearch();
  }

  public static void googleSearch() {
    String projectPath = System.getProperty("user.dir");
    System.out.println("This is your poject path: \n" + projectPath);

    System.setProperty(
        "webdriver.chrome.driver", projectPath + "/drivers/chromedrive/chromedriver.exe");

     driver = new ChromeDriver();
     driver.get("http://google.com");
    
    GoogleSearchPage.searchBox(driver).sendKeys("automation step by step");
    GoogleSearchPage.searchBox(driver).submit();
    
    
   driver.close();
   System.out.println("test completed successfully!");
  }
}
