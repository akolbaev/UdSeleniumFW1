import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo {

  public static void main(String[] args) {
	
    // TODO Auto-generated method stub
	   String projectPath = System.getProperty("user.dir");
	    System.out.println("This is your poject path: \n" + projectPath);
	    
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("ignoreProtectedModeSettings", true);
	    
	    System.setProperty(
	        "webdriver.ie.driver", projectPath + "/drivers/iedriver/IEDriverServer.exe");
	    WebDriver driver = new InternetExplorerDriver(caps);
	    
	    driver.get("https://google.com");
	    driver.findElement(By.name("q")).sendKeys("Barcelona");
	    driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
	    
	    driver.close();
	    driver.quit();
  }
}
