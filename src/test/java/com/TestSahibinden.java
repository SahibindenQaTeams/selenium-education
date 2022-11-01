package com;

import logs.LogsTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestSahibinden {

  private static final Logger logger = LogManager.getLogger(TestSahibinden.class);

  ChromeDriver driver;

  @BeforeEach
  public void beforeEach() {
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");

    ChromeOptions chromeOptions = new ChromeOptions();
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    chromeOptions.merge(capabilities);
    driver = new ChromeDriver(chromeOptions);
    logger.info("ChromeDriver oluşturuldu.");
    //System.out.println("ChromeDriver oluşturuldu.");
  }

  @AfterEach
  public void afterEach() {
    driver.quit();
    //System.out.println("ChromeDriver kapandı.");
    logger.info("ChromeDriver kapandı.");
  }

  @Test
  public void test() {
    driver.get("https://www.google.com/");
  }

  @ParameterizedTest
  @ValueSource(strings = {"email_1_@outlook.com", "email_2_@hotmail.com",
      "email_3_@sahibinden.com"})
  public void parameterizedTest(String email) throws InterruptedException {
    driver.get("https://secure.sahibinden.com/giris");

    Thread.sleep(10 * 1000);

    driver.findElement(By.id("username")).sendKeys(email);
    driver.findElement(By.id("userLoginSubmitButton")).click();

    Thread.sleep(10 * 1000);

  }

  @ParameterizedTest
  @CsvSource({"email_1_@outlook.com,sifre1,Hatalı Şifre Girdiniz", "email_2_@hotmail.com,sifre2,",
      "email_3_@sahibinden.com,sifre3,"})
  public void parameterizedTest2(String email, String password, String errorMessage)
      throws InterruptedException {

    logger.info("Error Message " + errorMessage);

    //System.out.println("Error Message -> " + errorMessage);

    driver.get("https://secure.sahibinden.com/giris");

    Thread.sleep(5 * 1000);

    driver.findElement(By.id("username")).sendKeys(email);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.id("userLoginSubmitButton")).click();

    Thread.sleep(5 * 1000);

  }

}
