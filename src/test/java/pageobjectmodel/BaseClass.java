package pageobjectmodel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;

public class BaseClass {

  WebDriver driver;

  @BeforeAll
  public static void beforeall() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  public void beforeTest() {
    driver = new ChromeDriver();

    driver.get("http://sahibinden.com/");

    LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
    localStorage.setItem("feature_discovery_data",
        "{\"add-to-favorites\":{\"count\":1,\"displayedAt\":1666694107010},\"extended\":true}");

    SessionStorage sessionStorage = ((WebStorage) driver).getSessionStorage();
    sessionStorage.setItem("feature_discovery_displayed", "true");
  }

  @AfterEach
  public void afterTest() {
    driver.quit();
  }
}
