package com;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;

public class SahibindenCookies {

  @Test
  public void testCookie() {
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
    ChromeDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
    driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);

    driver.get("https://www.sahibinden.com/");
    driver.manage().addCookie(new Cookie("testekibi", "egitim"));

    Cookie cookie = driver.manage().getCookieNamed("testekibi");

    System.out.println(cookie);
  }

  @Test
  public void testOnurBulduCookie() {
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
    ChromeDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
    driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);

    driver.get("https://sahibinden.com");

    LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
    localStorage.setItem("feature_discovery_data",
        "{\"add-to-favorites\":{\"count\":1,\"displayedAt\":1666694107010},\"extended\":true}");

    SessionStorage sessionStorage = ((WebStorage) driver).getSessionStorage();
    sessionStorage.setItem("feature_discovery_displayed", "true");

    driver.get("https://sahibinden.com/1052187105");
  }

  @Test
  public void testConnectToTestbox() {
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
    ChromeDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
    driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);

    driver.get("https://sahibinden.com");

    List<Cookie> cookieList = new ArrayList<>();
    cookieList.add(new Cookie("testBox", "54", ".sahibinden.com", "/", null));
    cookieList.add(new Cookie("tbSite", "x", ".sahibinden.com", "/", null));
    cookieList.forEach(cookie -> driver.manage().addCookie(cookie));

    driver.navigate().refresh();
  }

  @Test
  public void testDragAndDrop() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
    ChromeDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
    driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);

    driver.get("https://demo.guru99.com/test/drag_drop.html");

    WebElement from = driver.findElement(By.id("credit2"));
    WebElement to = driver.findElement(By.cssSelector("#bank li"));

    Actions actions = new Actions(driver);
    actions.dragAndDrop(from, to).build().perform();
    Thread.sleep(10000);
    driver.quit();
  }

  @Test
  public void testDoubleClick() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
    ChromeDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
    driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);

    driver.get("https://demo.guru99.com/test/simple_context_menu.html");

    WebElement button = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));

    Actions actions = new Actions(driver);
    actions.doubleClick(button).perform();
    Thread.sleep(10000);

    driver.quit();
  }

  @Test
  public void testCaptureScreenshot(){
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
    ChromeDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
    driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);

    driver.get("https://secure.sahibinden.com/giris");

    String imageBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    byte[] imageByte = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    driver.quit();
  }
}
