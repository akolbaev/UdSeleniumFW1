package demo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {
	
	WebDriver driver = null;
	
	@BeforeTest
	@Parameters("browserName")
	public void setUp(String browserName) {
		System.out.println("Browswer name is: "+browserName ); 
		System.out.println("Threa id: " +Thread.currentThread().getId()); 
		
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("This is your poject path: \n" + projectPath);
	
		
		if(browserName.equalsIgnoreCase("chrome")) {
		    System.setProperty(
			        "webdriver.chrome.driver", 
			        projectPath + "/drivers/chromedrive/chromedriver.exe");
			 driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("ie")) {
			 System.setProperty(
				        "webdriver.ie.driver", 
				        projectPath + "/drivers/iedriver/IEDriverServer.exe");
				 driver = new InternetExplorerDriver();
		}
			
		
	}
	
	@Test
	public void test1() throws InterruptedException {
		driver.get("https://google.com");
		Thread.sleep(4000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Test completed successfully" ); 
	}
}
