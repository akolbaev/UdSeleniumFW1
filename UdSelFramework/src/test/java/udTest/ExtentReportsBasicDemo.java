package udTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {
  private static WebDriver driver = null;

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
    // create ExtentReports and attach reporter(s)
    ExtentReports extent = new ExtentReports();
    extent.attachReporter(htmlReporter);

    // creates a toggle for the given test, adds all log events under it
    ExtentTest test1 =
        extent.createTest(
            "Google Search Test 1", "This is a test to validate google search funcionality");
    String projectPath = System.getProperty("user.dir");
    System.out.println("This is your poject path: \n" + projectPath);

    System.setProperty(
        "webdriver.chrome.driver", projectPath + "/drivers/chromedrive/chromedriver.exe");
    driver = new ChromeDriver();
    
    // log(Status, details)
    test1.log(Status.INFO, "Starting the test case");
    
    driver.get("https://google.com");
    test1.pass("Navigated to google.com");
          
    driver.findElement(By.name("q")).sendKeys("Extent Report");
    test1.pass("Entered a text in searchbox");
    driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
    test1.pass("Pressed the search button");
    
    driver.close();
    test1.pass("closed the browser");
    driver.quit();
    test1.info("Test Completed");
    
    ExtentTest test2 =
            extent.createTest(
                "Google Search Test 2", "This is a test to validate google search funcionality");
    String projectPath2 = System.getProperty("user.dir");
    System.out.println("This is your poject path: \n" + projectPath);

    System.setProperty(
        "webdriver.chrome.driver", projectPath2 + "/drivers/chromedrive/chromedriver.exe");
    driver = new ChromeDriver(); 
        
        // log(Status, details)
    test2.log(Status.INFO, "Starting the test case");
        
        driver.get("https://google.com");
        test2.fail("Navigated to google.com");
              
        driver.findElement(By.name("q")).sendKeys("Extent Report");
        test2.pass("Entered a text in searchbox");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        test2.pass("Pressed the search button");
        
        driver.close();
        test2.pass("closed the browser");
        driver.quit();
        test2.info("Test Completed");
    // calling flush writes everything to the log file/ you need to flush
    extent.flush();
  }
}
