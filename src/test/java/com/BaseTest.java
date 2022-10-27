package com;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

  ChromeDriver driver;

  @BeforeEach
  public void beforeTest() {
    System.out.println("BeforeEach'e girdi");
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
    driver = new ChromeDriver();
  }

  @AfterEach
  public void afterTest() {
    System.out.println("AfterEach'e girdi");
    driver.quit();
  }

}
