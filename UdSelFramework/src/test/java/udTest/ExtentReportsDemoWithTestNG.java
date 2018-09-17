package udTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemoWithTestNG {
  WebDriver driver = null;
  private static ExtentReports extent;
  private static ExtentHtmlReporter htmlReporter;

  @BeforeSuite
  public void setUP() {
    htmlReporter = new ExtentHtmlReporter("extentReportsWithTestNG.html");
    // create ExtentReports and attach reporter(s)
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
  }

  @BeforeTest
  public void setUpTest() {
    String projectPath = System.getProperty("user.dir");
    System.out.println("This is your poject path: \n" + projectPath);

    System.setProperty(
        "webdriver.chrome.driver", projectPath + "/drivers/chromedrive/chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void test1() throws IOException {
    ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
    driver.get("https://google.com");
    test.pass("Navigated to google.com");
    // log(Status, details)
    test.log(Status.INFO, "This step shows usage of log(status, details)");
    test.info("This step shows usage of info(details)");
    // log with snapshot
    test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
    test.addScreenCaptureFromPath("screenshot.png");
  }

  @Test
  public void test2() throws IOException {
    ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
    // log(Status, details)
    test.log(Status.INFO, "This stepshows usage of log(status, details)");
    test.info("This step shows usage of info(details)");
    // log with snapshot
    test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
    test.addScreenCaptureFromPath("screenshot.png");
  }
  @AfterTest
  public void tearDownTest() throws InterruptedException {
	 Thread.sleep(3000);
    driver.close();
    System.out.println("test completed successfully!");
  }
  @AfterSuite
  public void tearDown() {
    extent.flush();
  }
}
