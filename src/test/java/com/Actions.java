package com;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {

  @Test
  public void createAction() {
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
    ChromeDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);

    driver.get("https://secure.sahibinden.com/giris");
    //driver.navigate().to("https://secure.sahibinden.com/giris");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
    WebElement username = driver.findElement(By.id("username"));
    username.sendKeys("esrakosee");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("****");

    wait.until(ExpectedConditions.elementToBeClickable(By.id("userLoginSubmitButton")));
    WebElement loginButton = driver.findElement(By.id("userLoginSubmitButton"));
    loginButton.click();
  }

  @Test
  public void createSahibindenCorporateUser() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
    ChromeDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 25);

    driver.get("https://secure.sahibinden.com/kayit/kurumsal/");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
    driver.findElement(By.id("name")).sendKeys("test");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("surname")));
    driver.findElement(By.id("surname")).sendKeys("ekibi");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    driver.findElement(By.id("email")).sendKeys("testekibi@gmail.com");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    driver.findElement(By.id("password")).sendKeys("testekibi123");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone")));
    driver.findElement(By.id("phone")).sendKeys("2626440804");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("category")));
    Select realEstateSelect = new Select(driver.findElement(By.id("category")));
    realEstateSelect.selectByVisibleText("Emlak");
    //select.selectByValue("200003");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
    Select citySelect = new Select(driver.findElement(By.id("city")));
    citySelect.selectByValue("34"); // istanbul

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("town")));
    WebElement town = driver.findElement(By.id("town"));

    Thread.sleep(3000);
    String isDisabled = town.getAttribute("disabled");
    System.out.println(isDisabled);

    if (isDisabled == null) {
      Select townSelect = new Select(town);
      townSelect.selectByVisibleText("Adalar");
    }

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quarter")));
    String nameAttribute = driver.findElement(By.cssSelector("#quarter")).getAttribute("name");
    System.out.println(nameAttribute);

    Thread.sleep(1500);
    Select quarterSelect = new Select(driver.findElement(By.cssSelector("#quarter")));
    quarterSelect.selectByVisibleText("Kaşıkadası");

    wait.until(
        ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Şahıs Şirketi']")));
    driver.findElement(By.xpath("//label[text()='Şahıs Şirketi']")).click();
  }

  @Test
  public void createCorporateUser2() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
    ChromeDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);

    WebDriverWait wait = new WebDriverWait(driver, 25);

    driver.get("https://secure.sahibinden.com/kayit/kurumsal/");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
    driver.findElement(By.id("name")).sendKeys("test1234");
    Thread.sleep(2000);

    String name = driver.findElement(By.id("name")).getText();
    System.out.println(name);

    boolean isDisplayedName = driver.findElement(By.id("name")).isDisplayed();
    System.out.println(isDisplayedName);
  }

  @Test
  public void testExceptionHandling() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
    ChromeDriver driver = new ChromeDriver();

    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
    //driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);

    try {
      driver.get("https://secure.sahibinden.com/giris");
    } catch (TimeoutException timeoutException) {
      System.out.println("sayfa yüklenemedi");
    }

    try {
      driver.findElement(By.id("hatalıelement"));
    } catch (NoSuchElementException ex) {
      throw new Exception("Sayfadaki element bulunamadı : " + ex);
    } catch (Exception ex) {
      System.out.println("element farklı bir hata aldı");
    }
  }

  @Test
  public void testStaleElementReferenceException() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
    ChromeDriver driver = new ChromeDriver();

    driver.get("https://secure.sahibinden.com/giris");

    driver.navigate().refresh();
    WebElement usernameElement = driver.findElement(By.id("username"));
    usernameElement.sendKeys("test");
  }
}
