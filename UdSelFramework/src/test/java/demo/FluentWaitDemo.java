package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class FluentWaitDemo {

  @Test
  public void test() throws InterruptedException {
    String projectPath = System.getProperty("user.dir");
    System.setProperty(
        "webdriver.chrome.driver", projectPath + "/drivers/chromedrive/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.get("https://google.com");
    driver.findElement(By.name("q")).sendKeys("BMW 128i");
    driver.findElement(By.name("q")).sendKeys(Keys.RETURN);



    // Adding fluent wait
    Wait<WebDriver> wait =
        new FluentWait<WebDriver>(driver)
            .withTimeout(30, TimeUnit.SECONDS)
            .pollingEvery(5, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);

    WebElement elementLink =
        wait.until(
            new Function<WebDriver, WebElement>() {
              public WebElement apply(WebDriver driver) {
                WebElement link =
                    driver.findElement(
                        By.partialLinkText("2012 BMW"));
                if (link.isEnabled()) {
                  System.out.println("Element found");
                }

                return link;
              }
            });

    elementLink.click();
    
    
    Thread.sleep(2500);
    driver.close();
    driver.quit();
  }
}
