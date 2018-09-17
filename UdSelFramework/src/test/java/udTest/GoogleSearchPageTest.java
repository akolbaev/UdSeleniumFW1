package udTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearchTest();
  }
	
	
	public static void googleSearchTest() {
		   String projectPath = System.getProperty("user.dir");
		    System.out.println("This is your poject path: \n" + projectPath);

		    System.setProperty(
		        "webdriver.chrome.driver", projectPath + "/drivers/chromedrive/chromedriver.exe");

		     driver = new ChromeDriver();
		     
		     
		     GoogleSearchPageObjects searchObj = new GoogleSearchPageObjects(driver);
		     driver.get("http://google.com");
		     searchObj.setTextInSearchBox("automation engineer");
		     searchObj.clickSearchBox();
		     driver.close();
	}
	
}
