import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
  public static void main(String[] args) throws InterruptedException {
    // WebDriverManager.chromedriver().setup(); // using boni garcia webdriver manager

    // Setting up webdriver ide suggested way
    String projectPath = System.getProperty("user.dir");
    System.out.println("This is your poject path: \n" + projectPath);

    // System.setProperty("webdriver.chrome.driver",
    // "C:\\Users\\leoskiy\\eclipse-workspace\\UdSelFramework\\drivers\\chromeDriver\\chromedriver.exe");
    System.setProperty(
        "webdriver.chrome.driver", 
        projectPath + "/drivers/chromedrive/chromedriver.exe");

    		WebDriver driver = new ChromeDriver();
    //		driver.get("https://www.seleniumhq.org/");
    //

    // Internet Exploere
//    System.setProperty("webdriver.ie.driver", 
//    		projectPath + "/drivers/iedriver/IEDriverServer.exe");
    
    //WebDriver driver = new InternetExplorerDriver();
    //driver.get("https://www.seleniumhq.org/");

    driver.get("http://google.com/");
    //driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("automation");
    //driver.findElement(By.className("q")).sendKeys("automation");
    WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search']"));
    searchBox.sendKeys("automation step by step");
    searchBox.submit();
    
    List<WebElement> listOfElements = driver.findElements(By.xpath("//input"));
    int count = listOfElements.size();
    System.out.println("Count of web elements: " + count);
    		
    Thread.sleep(3000); // wait for 3 seconds
    driver.close();
  }
}
