package webdrivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManagerTest {

  WebDriver driver;

  @BeforeAll
  public static void chromeSetup() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  public void beforeTest() {
    driver = new ChromeDriver();
  }

  @AfterEach
  public void afterTest() {
    driver.close();
    driver.quit();
  }

  @Test
  public void test1() throws InterruptedException {
    Thread.sleep(10000);
  }
}
